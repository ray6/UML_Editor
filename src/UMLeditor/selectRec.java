package UMLeditor;

import java.awt.*;

public class selectRec {
    private int X1;
    private int Y1;
    private int X2;
    private int Y2;
    public selectRec() {
        X1 = 0;
        Y1 = 0;
        X2 = 0;
        Y2 = 0;
    }
    public void setXY1(int x, int y){
        X1 = x;
        Y1 = y;
        X2 = x;
        Y2 = y;
    }
    public void setXY2(int x, int y){
        X2 = x;
        Y2 = y;
    }
    public void setZero(){
        X1 = 0;
        Y1 = 0;
        X2 = 0;
        Y2 = 0;
    }
    public void draw(Graphics g) {
        g.setColor(Color.green);
        g.drawRect(Math.min(X1, X2), Math.min(Y1, Y2), Math.abs(X1-X2), Math.abs(Y1-Y2));
    }
}
