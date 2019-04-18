package BasicObject;

import BasicObject.BasicObject;

import java.awt.*;

public abstract class ShapeObject extends BasicObject {
    //Position
    protected int X;
    protected int Y;
    protected int W;
    protected int H;
    protected String name;

    //Connection port
    protected Port North;
    protected Port South;
    protected Port WEST;
    protected Port EAST;

    // Status
    protected boolean selected = true;

    protected ShapeObject(int x, int y){
        X = x;
        Y = y;

        North = new Port();
        South = new Port();
        WEST = new Port();
        EAST = new Port();

    }
    private void setPort(){
        North.setXY(X+W/2, Y);
        South.setXY(X+W/2, Y+H);
        EAST.setXY(X, Y+H/2);
        WEST.setXY(X+W, Y+H/2);
    }
    public void draw(Graphics g){
        // draw port
        if (selected){
            setPort();
            North.draw(g);
            South.draw(g);
            WEST.draw(g);
            EAST.draw(g);
        }
    }

}

