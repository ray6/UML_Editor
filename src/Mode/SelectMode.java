package Mode;


import UMLeditor.MyCanvas;

import java.awt.event.MouseEvent;

public class SelectMode extends Mode {
    private int X1, Y1, X2, Y2;
    private boolean Moving = false;
    public SelectMode (MyCanvas canvas){
        super(canvas);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        canvas.InitSelectList();
        canvas.selectComponent(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        X1 = e.getX();
        Y1 = e.getY();
        // Check if mouse pressed in Selected object, else check if it selected a single obj.
        if (canvas.inSelectedObject(X1, Y1)){
            Moving = true;
        }
        else {
            canvas.InitSelectList();
            canvas.selectComponent(X1, Y1);
        }
        //Because selected status might be changed rechecked if mouse clicked in Selected object.
        //If didn't press in selected object, draw a selecting Rectangle.
        if (canvas.inSelectedObject(X1, Y1)){
            Moving = true;
        }
        else {
            canvas.setR_start(X1, Y1);
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
            canvas.setR_end(X2, Y2);
            canvas.clearR();
            canvas.InitSelectList();
            canvas.selectRangeComponent(X1, Y1, X2, Y2);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        X2 = e.getX();
        Y2 = e.getY();
        if (Moving){
            canvas.MoveSelectedComponent(X2-X1, Y2-Y1);
            X1 = X2;
            Y1 = Y2;
        }
        else {
            canvas.setR_end(X2, Y2);
        }
    }
}
