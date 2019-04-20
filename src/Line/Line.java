package Line;

import BasicObject.Port;

import java.awt.*;

public abstract class Line {
    protected Port Start;
    protected Port End;
    public Line(Port start, Port end){
        Start = start;
        End = end;
    }
    public abstract void drawline(Graphics g);
}
