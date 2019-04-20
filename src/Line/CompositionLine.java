package Line;

import BasicObject.Port;

import java.awt.*;

public class CompositionLine extends PolygonLine {

    public CompositionLine(Port start, Port end){
        super(start, end);
        corner_num = 4;
    }

}
