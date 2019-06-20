package BasicObject;

import java.awt.*;

public class Class extends BasicObject {

    public Class(int x, int y){
        super(x, y);
        W = 80;
        H = 99;
        name = "Class";
    }

    public void draw(Graphics g){
        g.setColor(Color.orange);
        g.fillRect(X, Y, W, H);
        g.setColor(Color.black);
        g.drawRect(X, Y, W, H);
        g.drawLine(X, Y+H/3, X+W, Y+H/3);
        g.drawLine(X, Y+2*H/3, X+W, Y+2*H/3);
        g.drawString(name, X+W/3, Y+H/5);
        super.draw(g);

    }
}
