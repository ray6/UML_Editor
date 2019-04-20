package UMLeditor;

import java.awt.*;

public class tmpLine {
    private int X1, X2, Y1, Y2;
    public tmpLine(){
        X1 = 0;
        X2 = 0;
        Y1 = 0;
        Y2 = 0;
    }
    public void setStart(int x, int y){
        X1 = x;
        Y1 = y;
        X2 = x;
        Y2 = y;
    }
    public void setXY2(int x, int y){
        X2 = x;
        Y2 = y;
    }
    public  void setZero(){
        X1 = 0;
        X2 = 0;
        Y1 = 0;
        Y2 = 0;
    }
    public void draw(Graphics g){
        g.setColor(Color.black);
        g.drawLine(X1, Y1, X2, Y2);
    }
}
