package UMLeditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import BasicObject.BasicObject;
import BasicObject.Class;
import BasicObject.UseCase;
import BasicObject.Composite;
import BasicObject.Port;
import Line.Line;
import Line.AssociationLine;
import Line.GeneralizationLine;
import Line.CompositionLine;
import Mode.*;
import UMLeditor.selectRec;
import Mode.AssociationMode;
import Mode.GeneralizationMode;
import Mode.CompositionMode;

public class MyCanvas extends JPanel {
    private Vector<BasicObject> ComponentList = new Vector<BasicObject>();
    private Vector<Line> LineList= new Vector<Line>();

    private MouseAdapter[] Modes = new MouseAdapter[7];
    private int currentMode = 6; //Set to initial Mode : null

    private Vector<BasicObject> selectedbojs = new Vector<BasicObject>();

    private selectRec R = new selectRec();
    private tmpLine L = new tmpLine();

    public MyCanvas() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(1000, 600));
        initMode();
    }
    public void AddToComponentList(BasicObject b){
        ComponentList.add(b);
        repaint();
    }
    public void AddToLineList(Line line){
        LineList.add(line);
        repaint();
    }
    public BasicObject getComponent(int x, int y){
        int Xdiff = 0;
        int Ydiff = 0;
        BasicObject lastobj = null;
        if(!ComponentList.isEmpty()) {
            for (BasicObject obj : ComponentList) {
                Xdiff = x - obj.getX();
                Ydiff = y - obj.getY();
                obj.setSelect(false);
                if (0 <= Xdiff && Xdiff <= obj.getW() && 0 <= Ydiff && Ydiff <= obj.getH()) {
                    lastobj = obj;
                }
            }
        }
        repaint();
        return lastobj;
    }
    public void setL_start(int x, int y){
        L.setStart(x, y);
        repaint();
    }
    public void setL_end(int x, int y){
        L.setXY2(x, y);
        repaint();
    }
    public void clearL(){
        L.setZero();
        repaint();
    }

    private void initMode(){
        /*
        Mode List :
           0 : Select,  1 : Association Line, 2 : Generalization Line
           3 : Composition Line,  4 : class,  5 : Use Case,  6 : NULL
        */
        MouseAdapter SelectMode = new MouseAdapter() {
            private int X1, X2, Y1, Y2;
            private boolean Moving = false;

            @Override
            public void mouseClicked(MouseEvent e) {
                if (!selectedbojs.isEmpty()) {selectedbojs.removeAllElements();}
                selectedbojs.add(getOBJ(e.getX(), e.getY()));
                repaint();
            }
            @Override
            public void mousePressed(MouseEvent e) {
                X1 = e.getX();
                Y1 = e.getY();
                // Check if mouse pressed in Selected object, else check if it selected a single obj.
                if (inSelectedObject(e.getX(), e.getY())){
                    Moving = true;
                }
                else {
                    if (!selectedbojs.isEmpty()) {selectedbojs.removeAllElements();}
                    selectedbojs.add(getOBJ(e.getX(), e.getY()));
                    repaint();
                }
                //Because selected status might be changed rechecked if mouse clicked in Selected object.
                //If didn't press in selected object, draw a selecting Rectangle.
                if (inSelectedObject(e.getX(), e.getY())){
                    Moving = true;
                }
                else {
                    R.setXY1(X1, Y1);
                    repaint();
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                X2 = e.getX();
                Y2 = e.getY();
                if (Moving){
                    Moving = false;
                }
                else {
                    R.setXY2(X2, Y2);
                    repaint();
                    R.setZero();
                    if (!selectedbojs.isEmpty()) {selectedbojs.removeAllElements();}
                    selectedbojs = getRangeOBJ();
                    repaint();
                }

            }
            @Override
            public void mouseDragged(MouseEvent e) {
                X2 = e.getX();
                Y2 = e.getY();
                if (Moving){
                    MoveSelectedOBJ(X2-X1, Y2-Y1);
                    repaint();
                    X1 = X2;
                    Y1 = Y2;
                }
                else {
                    R.setXY2(X2, Y2);
                    repaint();
                }
            }

            private Vector<BasicObject> getRangeOBJ(){
                Vector<BasicObject> selectobj = new Vector<BasicObject>();
                int x1 = Math.min(X1, X2);
                int x2 = Math.max(X1, X2);
                int y1 = Math.min(Y1, Y2);
                int y2 = Math.max(Y1, Y2);
                int obj_x, obj_y, obj_w, obj_h;
                boolean LeftUpPoint, RightDownPoint, GoThrough;
                if (!ComponentList.isEmpty()){
                    for (BasicObject obj : ComponentList){
                        obj.setSelect(false);

                        obj_x = obj.getX();
                        obj_y = obj.getY();
                        obj_w = obj.getW();
                        obj_h = obj.getH();
                        LeftUpPoint = (x1<=obj_x && obj_x<=x2 && y1<=obj_y && obj_y<=y2);
                        RightDownPoint = (x1<=obj_x+obj_w && obj_x+obj_w<=x2 && y1<=obj_y+obj_h && obj_y+obj_h<=y2);
//                        GoThrough = ((obj_x<=x1 && x2<=obj_x+obj_w)||(obj_y<=y1 && y2<=obj_y+obj_h));
                        if ( LeftUpPoint && RightDownPoint ){
                            obj.setSelect(true);
                            selectobj.add(obj);
                        }
                    }
                }
                return selectobj;
            }
            private boolean inSelectedObject(int x, int y){
                int Xdiff = 0;
                int Ydiff = 0;
                if(!ComponentList.isEmpty()) {
                    for (BasicObject obj : ComponentList) {
                        if (obj.isSelected()){
                            Xdiff = x - obj.getX();
                            Ydiff = y - obj.getY();
                            if (0 <= Xdiff && Xdiff <= obj.getW() && 0 <= Ydiff && Ydiff <= obj.getH()) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            private void MoveSelectedOBJ(int Delta_x, int Delta_y){
                if (!selectedbojs.isEmpty()){
                    for (BasicObject obj : selectedbojs){
                        if(!obj.isGrouped()){
                            obj.Move(Delta_x, Delta_y);
                        }
                    }
                }
            }
            private BasicObject getOBJ(int x, int y){
                int Xdiff = 0;
                int Ydiff = 0;
                BasicObject lastobj = null;
                if(!ComponentList.isEmpty()) {
                    for (BasicObject obj : ComponentList) {
                        Xdiff = x - obj.getX();
                        Ydiff = y - obj.getY();
                        obj.setSelect(false);
                        if (0 <= Xdiff && Xdiff <= obj.getW() && 0 <= Ydiff && Ydiff <= obj.getH()) {
                            lastobj = obj;
                        }
                    }
                }
                if (lastobj != null){ lastobj.setSelect(true); }
                return lastobj;
            }
        };
        
        Modes[0] = SelectMode;
        Modes[1] = new AssociationMode(this);
        Modes[2] = new GeneralizationMode(this);
        Modes[3] = new CompositionMode(this);
        Modes[4] = new ClassMode(this);
        Modes[5] = new UseCaseMode(this);

        Modes[6] = null; // In begining there is no Listener.
    }

    public void ModeSwitcher(int mode){
        selectedbojs.removeAllElements();
        removeMouseListener(Modes[currentMode]);
        removeMouseMotionListener(Modes[currentMode]);
        addMouseListener(Modes[mode]);
        addMouseMotionListener(Modes[mode]);
        currentMode = mode;
        repaint();
    }
    public boolean isSelecting(){
        if (currentMode == 0 && !selectedbojs.isEmpty()){
            return true;
        }
        else return false;
    }
    public void Group(){
        int min_X=Integer.MAX_VALUE, min_Y=Integer.MAX_VALUE, max_X=0, max_Y=0;
        for (BasicObject obj : selectedbojs){
            obj.setGrouped(true);
            if (min_X > obj.getX()){
                min_X = obj.getX();
            }
            if (min_Y > obj.getY()){
                min_Y = obj.getY();
            }
            if (max_X < obj.getX()+obj.getW()){
                max_X = obj.getX()+obj.getW();
            }
            if (max_Y < obj.getY()+obj.getH()){
                max_Y = obj.getY()+obj.getH();
            }
        }
        ComponentList.add(new Composite(min_X, min_Y, max_X-min_X, max_Y-min_Y, selectedbojs));
        repaint();
    }
    public void UnGroup(){
        if (selectedbojs.size() == 1) {
            BasicObject obj = selectedbojs.remove(0);
            obj.delete(ComponentList, "Composite");
        }
        repaint();
    }
    public void setSelectedName(String name){
        if (selectedbojs.size() == 1) {
            selectedbojs.get(0).setName(name);
            repaint();
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (BasicObject object : ComponentList){
            object.draw(g);
        }
        for (Line line : LineList){
            line.drawline(g);
        }
        R.draw(g);
        L.draw(g);
    }
}
