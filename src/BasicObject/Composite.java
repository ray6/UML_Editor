package BasicObject;

import java.awt.*;
import java.util.Vector;
import BasicObject.BasicObject;

public class Composite extends BasicObject {
    Vector<BasicObject> MemberList = new Vector<BasicObject>();
    public Composite(int x, int y, int w, int h, Vector<BasicObject> GroupList){
        super(x, y);
        W = w;
        H = h;
        type = "Composite";
        for (BasicObject obj : GroupList){
            obj.setSelect(false);
            if (!obj.isGrouped()){
                MemberList.add(obj);
                obj.setGrouped(true);
            }
        }
        this.setSelect(true);
    }
    public void Move(int Delta_x, int Delta_y){
        super.Move(Delta_x, Delta_y);
        for (BasicObject obj : MemberList) {
            obj.Move(Delta_x, Delta_y);
        }
    }
    public void delete(Vector<BasicObject> ComponentList, String type){
        for (BasicObject obj : MemberList){
            obj.setGrouped(false);
        }
        super.delete(ComponentList, type);
    }
    public Port getConnectPort(int x, int y){
        return null;
    }
    @Override
    public void draw(Graphics g) {
        super.draw(g);
        if (selected){
            g.setColor(Color.BLUE);
            g.drawRect(X, Y,W,H);
        }
    }
}
