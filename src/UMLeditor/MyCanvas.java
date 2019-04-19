package UMLeditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;
import BasicObject.BasicObject;
import BasicObject.Class;
import BasicObject.UseCase;
import UMLeditor.selectRec;
import BasicObject.ShapeObject;
//import Mode.*;

public class MyCanvas extends JPanel {
    private Vector<BasicObject> ComponentList = new Vector<BasicObject>();
    private MouseAdapter[] Modes = new MouseAdapter[7];
    private int currentMode = 6; //Set to initial Mode : null
    private selectRec R = new selectRec();


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
        MouseAdapter SelectMode = new MouseAdapter() {
            private int X1, X2, Y1, Y2;
            private boolean Moving = false;
            private Vector<BasicObject> selectedbojs = new Vector<BasicObject>();
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

            private void MoveSelectedOBJ(int Delta_x, int Delta_y){
                if (!selectedbojs.isEmpty()){
                    for (BasicObject obj : selectedbojs){
                        obj.setX(obj.getX()+Delta_x);
                        obj.setY(obj.getY()+Delta_y);
                    }
                }
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
            private BasicObject getOBJ(int x, int y){
                int Xdiff = 0;
                int Ydiff = 0;
                BasicObject lastobj = null;
                if(!ComponentList.isEmpty()) {
                    for (BasicObject obj : ComponentList) {
                        Xdiff = x - obj.getX();
                        Ydiff = y - obj.getY();
                        obj.Unselect();
                        if (0 <= Xdiff && Xdiff <= obj.getW() && 0 <= Ydiff && Ydiff <= obj.getH()) {
                            obj.Select();
                            lastobj = obj;
                        }
                    }
                }
                return lastobj;
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
                        obj.Unselect();

                        obj_x = obj.getX();
                        obj_y = obj.getY();
                        obj_w = obj.getW();
                        obj_h = obj.getH();
                        LeftUpPoint = (x1<=obj_x && obj_x<=x2 && y1<=obj_y && obj_y<=y2);
                        RightDownPoint = (x1<=obj_x+obj_w && obj_x+obj_w<=x2 && y1<=obj_y+obj_h && obj_y+obj_h<=y2);
                        GoThrough = ((obj_x<=x1 && x2<=obj_x+obj_w)||(obj_y<=y1 && y2<=obj_y+obj_h));
                        if ( LeftUpPoint|| RightDownPoint || GoThrough ){
                            obj.Select();
                            selectobj.add(obj);
                        }
                    }
                }
                return selectobj;
            }

        };
        MouseAdapter AssLineMode = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setBackground(Color.black);
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
            }
        };
        MouseAdapter GenLineMode = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setBackground(Color.BLUE);
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
            }
        };
        MouseAdapter ComLineMode = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setBackground(Color.CYAN);
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
            }
        };
        MouseAdapter ClassMode = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ComponentList.add(new Class(e.getX(), e.getY()));
                repaint();
            }};
        MouseAdapter UseCaseMode = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ComponentList.add(new UseCase(e.getX(), e.getY()));
                repaint();
            }};

        Modes[0] = SelectMode;
        Modes[1] = AssLineMode;
        Modes[2] = GenLineMode;
        Modes[3] = ComLineMode;
        Modes[4] = ClassMode;
        Modes[5] = UseCaseMode;

        Modes[6] = null; // In begining there is no Listener.
    }

    public void ModeSwitcher(int mode){
        removeMouseListener(Modes[currentMode]);
        removeMouseMotionListener(Modes[currentMode]);
        addMouseListener(Modes[mode]);
        addMouseMotionListener(Modes[mode]);
        currentMode = mode;
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (BasicObject object : ComponentList){
            object.draw(g);
        }
        R.draw(g);
    }
}
