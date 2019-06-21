package Shape;

import java.awt.*;
import java.util.Vector;

public abstract class Shape {

    // Status
    protected boolean selected = false;
    protected boolean grouped = false;

    //Select status
    public void setSelect(boolean b){ selected = b; }
    public boolean isSelected(){ return selected; }

    //Group status
    public void setGrouped(boolean b){ grouped = b; }
    public boolean isGrouped(){ return grouped; }

    //get and set Port
    //always set port when paint.
    private void setPort(){
        //do nothing
    }
    public Port getConnectPort(int x, int y){
       // do nothing
        return null;
    }

    //Get Coordinate of Object
    public int getX(){ /*do nothing*/return 0; }
    public int getY(){ /*do nothing*/return 0; }
    public int getW(){ /*do nothing*/return 0; }
    public int getH(){ /*do nothing*/return 0; }

    //set Position of Object with distance difference
    public void Move(int Delta_x, int Delta_y){
        //do nothing
    }

    public void setX(int x){ /*do nothing*/ }
    public void setY(int y){ /*do nothing*/ }

    //set Name
    public void setName(String name){
        //do nothing
    }

    //delete self when type is fit
    public void delete(Vector<Shape> ComponentList, String type){
        // do nothing
    }
    
    public abstract void draw(Graphics g);
}
