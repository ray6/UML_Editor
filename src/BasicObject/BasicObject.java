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

    //get and set Port
    //always set port when paint.
    private void setPort(){
        North.setXY(X+W/2, Y);
        South.setXY(X+W/2, Y+H);
        WEST.setXY(X, Y+H/2);
        EAST.setXY(X+W, Y+H/2);
    }
    public Port getConnectPort(int x, int y){
        Port[][] Position = {{North, WEST},{EAST, South}};
        //Set Center(X+W/2, Y+H/2) to origin point (0, 0).
        x = x-X-W/2;
        y = y-Y-H/2;
        double point_on_LDRULine = ((double)H/(double)W)*x; //LeftDownToRighUpLine
        double point_on_LURDLine = (-point_on_LDRULine); //LeftUpToRightDownline

        return Position[point_on_LURDLine > y ? 0 : 1][point_on_LDRULine > y ? 0 : 1];

    }

    //Get Coordinate of Object
    public int getX(){ return X; }
    public int getY(){ return Y; }
    public int getW(){ return W; }
    public int getH(){ return H; }

    //set Position of Object
    public void Move(int Delta_x, int Delta_y){
        X = X + Delta_x;
        Y = Y + Delta_y;
    }
    public void setX(int x){ X = x; }
    public void setY(int y){ Y = y; }

    //Select status
    public void setSelect(boolean b){ selected = b; }
    public boolean isSelected(){ return selected; }

    //Group status
    public void setGrouped(boolean b){ grouped = b; }
    public boolean isGrouped(){ return grouped; }

    //set Name
    public void setName(String name){
        this.name = name;
    }

    //delete self when type is fit
    public void delete(Vector<BasicObject> ComponentList, String type){
        // do nothing
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
