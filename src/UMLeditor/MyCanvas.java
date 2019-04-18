package UMLeditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;
import BasicObject.BasicObject;
import BasicObject.Class;
import BasicObject.UseCase;
//import Mode.*;

public class MyCanvas extends JPanel {
    private Vector<BasicObject> ComponentList = new Vector<BasicObject>();
    private MouseAdapter[] Modes = new MouseAdapter[7];
    private int currentMode = 6; //Set to initial Mode : null

    public MyCanvas() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(1000, 600));
        initMode();
    }

    public void ModeSwitcher(int mode){
        removeMouseListener(Modes[currentMode]);
        addMouseListener(Modes[mode]);
        currentMode = mode;
        repaint();
    }
    private void initMode(){
        /*
        Mode List :
           0 : Select,  1 : Association Line, 2 : Generalization Line
           3 : Composition Line,  4 : class,  5 : Use Case,  6 : NULL
        */
        MouseAdapter SelectMode = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setBackground(Color.PINK);
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
        MouseAdapter UseCaseMode = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ComponentList.add(new UseCase(e.getX(), e.getY()));
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

        Modes[0] = SelectMode;
        Modes[1] = AssLineMode;
        Modes[2] = GenLineMode;
        Modes[3] = ComLineMode;
        Modes[4] = ClassMode;
        Modes[5] = UseCaseMode;

        Modes[6] = null; // In begining there is no Listener.
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!ComponentList.isEmpty()){
            for (int i=0;i < ComponentList.size(); i++){
                ComponentList.get(i).draw(g);
            }
        }

    }

}
