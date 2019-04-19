package BasicObject;
import java.awt.*;
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
        EAST.setXY(X, Y+H/2);
        WEST.setXY(X+W, Y+H/2);
    }
    public int getX(){ return X; }
    public int getY(){ return Y; }
    public int getW(){ return W; }
    public int getH(){ return H; }
    public void setX(int x){ X = x; }
    public void setY(int y){ Y = y; }
    public void Select(){ selected = true; }
    public void Unselect(){ selected = false;}
    public boolean isSelected(){ return selected; }

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
