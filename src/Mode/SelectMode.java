package Mode;


import UMLeditor.MyCanvas;

import java.awt.event.MouseEvent;

public class SelectMode extends Mode {
    private int X1, Y1, X2, Y2;
    private boolean Moving = false;
    @Override
    public void mouseClicked(MouseEvent e) {
        MyCanvas.getInstance().InitSelectList();
        MyCanvas.getInstance().selectComponent(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        X1 = e.getX();
        Y1 = e.getY();
        // Check if mouse pressed in Selected object, else check if it selected a single obj.
        if (MyCanvas.getInstance().inSelectedObject(X1, Y1)){
            Moving = true;
        }
        else {
            MyCanvas.getInstance().InitSelectList();
            MyCanvas.getInstance().selectComponent(X1, Y1);
        }
        //Because selected status might be changed rechecked if mouse clicked in Selected object.
        //If didn't press in selected object, draw a selecting Rectangle.
        if (MyCanvas.getInstance().inSelectedObject(X1, Y1)){
            Moving = true;
        }
        else {
            MyCanvas.getInstance().setR_start(X1, Y1);
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
            MyCanvas.getInstance().setR_end(X2, Y2);
            MyCanvas.getInstance().clearR();
            MyCanvas.getInstance().InitSelectList();
            MyCanvas.getInstance().selectRangeComponent(X1, Y1, X2, Y2);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        X2 = e.getX();
        Y2 = e.getY();
        if (Moving){
            MyCanvas.getInstance().MoveSelectedComponent(X2-X1, Y2-Y1);
            X1 = X2;
            Y1 = Y2;
        }
        else {
            MyCanvas.getInstance().setR_end(X2, Y2);
        }
    }
}
