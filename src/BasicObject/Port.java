package BasicObject;

import java.awt.*;

public class Port {
    private int X;
    private int Y;
    private int W = 10;
    private int H = 10;

    public Port(){};

    public void setXY(int x, int y){
        X = x-W/2;
        Y = y-H/2;
    }
    public void draw(Graphics g){
        g.setColor(Color.black);
        g.fillRect(X, Y, W, H);
    }
}
