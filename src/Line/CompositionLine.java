package Line;

import Shape.Port;

import java.awt.*;

public class CompositionLine extends Line {
    protected int corner_num;
    protected int[][] points;
    //points[0] : x coordinate
    //points[1] : y coordinate
    public CompositionLine(Port start, Port end){
        super(start, end);
        corner_num = 4;
    }
    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(Start.getX(), Start.getY(), End.getX(), End.getY());
        points = getRegularPolygon(Start.getX(), Start.getY(), End.getX(), End.getY(), corner_num);
        g.fillPolygon(points[0], points[1], corner_num);
    }
}
