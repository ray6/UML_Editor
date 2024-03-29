package Line;

import Shape.Port;

import java.awt.*;

public class AssociationLine extends Line{
    public AssociationLine(Port start, Port end){
        super(start, end);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(Start.getX(), Start.getY(), End.getX(), End.getY());
    }
}
