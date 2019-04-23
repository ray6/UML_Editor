package UMLeditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import BasicObject.BasicObject;
import BasicObject.Composite;
import Line.Line;
import Mode.*;

public class MyCanvas extends JPanel {
    //List
    private Vector<BasicObject> ComponentList = new Vector<BasicObject>();
    private Vector<Line> LineList= new Vector<Line>();
    private Vector<BasicObject> SelectList = new Vector<BasicObject>();

    //Mode
    private MouseAdapter[] Modes = new MouseAdapter[7];
    private int currentMode = 6; //Set to initial Mode : null

    //Assistant
    private selectRec R = new selectRec();
    private tmpLine L = new tmpLine();

    //Constructor
    public MyCanvas() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(1000, 600));
        initMode();
    }
    private void initMode(){
        /*
        Mode List :
           0 : Select,  1 : Association Line, 2 : Generalization Line
           3 : Composition Line,  4 : class,  5 : Use Case,  6 : NULL
        */
        Modes[0] = new SelectMode(this);
        Modes[1] = new AssociationMode(this);
        Modes[2] = new GeneralizationMode(this);
        Modes[3] = new CompositionMode(this);
        Modes[4] = new ClassMode(this);
        Modes[5] = new UseCaseMode(this);

        Modes[6] = null; // In begining there is no Listener.
    }

    //List Operator
    public void AddToComponentList(BasicObject b){
        ComponentList.add(b);
        repaint();
    }
    public void AddToLineList(Line line){
        LineList.add(line);
        repaint();
    }
    //SelectList Operator
    public void InitSelectList(){
        if (!SelectList.isEmpty()){
            SelectList.removeAllElements();
        }
    }
    public void selectComponent(int x, int y){
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
        if (lastobj != null){
            lastobj.setSelect(true);
            SelectList.add(lastobj);
        }
        repaint();
    }
    public void selectRangeComponent(int X1, int Y1, int X2, int Y2){
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
                    SelectList.add(obj);
                }
            }
        }
        repaint();
    }
    //Selected Object Operator
    public void MoveSelectedComponent(int Delta_x, int Delta_y){
        if (!SelectList.isEmpty()){
            for (BasicObject obj : SelectList){
                if(!obj.isGrouped()){
                    obj.Move(Delta_x, Delta_y);
                }
            }
            repaint();
        }
    }

    //Status
    public boolean inSelectedObject(int x, int y){
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
    public boolean isSelecting(){
        if (currentMode == 0 && !SelectList.isEmpty()){
            return true;
        }
        else return false;
    }

    //get Component of the position
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

    //Assistant Operator
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
    public void setR_start(int x, int y){
        R.setXY1(x, y);
        repaint();
    }
    public void setR_end(int x, int y){
        R.setXY2(x, y);
        repaint();
    }
    public void clearR(){
        R.setZero();
        repaint();
    }

    //ModeSwitcher
    public void ModeSwitcher(int mode){
        SelectList.removeAllElements();
        removeMouseListener(Modes[currentMode]);
        removeMouseMotionListener(Modes[currentMode]);
        addMouseListener(Modes[mode]);
        addMouseMotionListener(Modes[mode]);
        currentMode = mode;
        repaint();
    }

    //Function
    public void Group(){
        int min_X=Integer.MAX_VALUE, min_Y=Integer.MAX_VALUE, max_X=0, max_Y=0;
        if (SelectList.size()>1){
            for (BasicObject obj : SelectList){

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
        }
        ComponentList.add(new Composite(min_X, min_Y, max_X-min_X, max_Y-min_Y, SelectList));
        repaint();
    }
    public void UnGroup(){
        if (SelectList.size() == 1) {
            BasicObject obj = SelectList.remove(0);
            obj.delete(ComponentList, "Composite");
        }
        repaint();
    }
    public void setSelectedName(String name){
        if (SelectList.size() == 1) {
            SelectList.get(0).setName(name);
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
