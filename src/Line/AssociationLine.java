package Line;

import BasicObject.Port;

import java.awt.*;

public class AssociationLine extends Line{
    public AssociationLine(Port start, Port end){
        super(start, end);
    }

    @Override
    public void drawline(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(Start.getCenterX(), Start.getCenterY(), End.getCenterX(), End.getCenterY());
    }
}
