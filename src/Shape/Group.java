package Shape;

import java.awt.*;
import java.util.Vector;
public class Group extends Shape {

    Vector<Shape> MemberList = new Vector<Shape>();
    //Position
    protected int X;
    protected int Y;
    protected int W;
    protected int H;

    public Group(int x, int y, int w, int h, Vector<Shape> GroupList){
        X = x;
        Y = y;
        W = w;
        H = h;
        for (Shape obj : GroupList){
            obj.setSelect(false);
            if (!obj.isGrouped()){
                MemberList.add(obj);
                obj.setGrouped(true);
            }
        }
        this.setSelect(true);
    }
    //Get Coordinate of Object
    public int getX(){ return X; }
    public int getY(){ return Y; }
    public int getW(){ return W; }
    public int getH(){ return H; }

    public void setX(int x){ X = x; }
    public void setY(int y){ Y = y; }

    public void Move(int Delta_x, int Delta_y){
        X = X + Delta_x;
        Y = Y + Delta_y;
        for (Shape obj : MemberList) {
            obj.Move(Delta_x, Delta_y);
        }
    }
    public void delete(Vector<Shape> ComponentList, String type){
        ComponentList.remove(this);
        for (Shape obj : MemberList){
            obj.setGrouped(false);
        }
        super.delete(ComponentList, type);
    }

    @Override
    public void draw(Graphics g) {
        if (selected){
            g.setColor(Color.BLUE);
            g.drawRect(X, Y,W,H);
        }
    }
}
