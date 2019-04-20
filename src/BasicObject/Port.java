package BasicObject;


import java.awt.*;

public class Port {
    private int X;
    private int Y;
    private int W = 8;
    private int H = 8;

    public Port(){};

    public void setXY(int x, int y){
        X = x-W/2;
        Y = y-H/2;
    }
    public int getCenterX(){ return X+W/2; }
    public int getCenterY(){ return Y+H/2; }
    public void draw(Graphics g){
        g.setColor(Color.black);
        g.fillRect(X, Y, W, H);
    }
}
