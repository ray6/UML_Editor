package BasicObject;

import java.awt.*;

public class Class extends ShapeObject {

    public Class(int x, int y){
        X = x;
        Y = y;
        W = 60;
        H = 100;
    }
    public void setXY(int x, int y){
        X = x;
        Y = y;
    }
    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        g.drawRect(X, Y, W, H);
    }
}
