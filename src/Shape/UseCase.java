package Shape;
import java.awt.*;

public class UseCase extends BasicObject {
    public UseCase(int x, int y){
        super(x, y);
        W = 99;
        H = 50;
        name = "Use Case";
    }
    @Override
    public void draw(Graphics g){
        g.setColor(Color.orange);
        g.fillOval(X, Y, W, H);
        g.setColor(Color.black);
        g.drawOval(X, Y, W, H);
        g.drawString(name, X+W/4, Y+H/2);
        super.draw(g);

    }
}
