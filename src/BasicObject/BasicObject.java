package BasicObject;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;
public abstract class BasicObject  {
    //Position
    protected int X;
    protected int Y;
    protected int W;
    protected int H;
    protected String name;
    protected String type;

    //Connection port
    protected Port North;
    protected Port South;
    protected Port WEST;
    protected Port EAST;


    // Status
    protected boolean selected = false;
    protected boolean grouped = false;

    protected BasicObject(int x, int y){
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
        WEST.setXY(X, Y+H/2);
        EAST.setXY(X+W, Y+H/2);
    }

    public Port getConnectPort(int x, int y){
        //Set Center(X+W/2, Y+H/2) to origin point (0, 0).
        x = x-X-W/2;
        y = y-Y-H/2;
        double m = (-(double)H/(double)W*x);
        if (m > y){
            if (-m >= y) { return North; }
            else { return WEST; }
        }
        else {
            if (-m> y) {return EAST; }
            else {return South; }
        }
    }
    public int getX(){ return X; }
    public int getY(){ return Y; }
    public int getW(){ return W; }
    public int getH(){ return H; }
    public void Move(int Delta_x, int Delta_y){
        X = X + Delta_x;
        Y = Y + Delta_y;
    }
    public void setX(int x){ X = x; }
    public void setY(int y){ Y = y; }
    public void setSelect(boolean b){ selected = b; }
    public boolean isSelected(){ return selected; }
    public void setGrouped(boolean b){ grouped = b; }
    public boolean isGrouped(){ return grouped; }
    public void setName(String name){
        this.name = name;
    }
    public void delete(Vector<BasicObject> ComponentList, String type){
        if (type == this.type){
            ComponentList.remove(this);
        }
    }
    public void draw(Graphics g){
        // draw port
        setPort();
        if (selected){
            North.draw(g);
            South.draw(g);
            WEST.draw(g);
            EAST.draw(g);
        }
    }
}
