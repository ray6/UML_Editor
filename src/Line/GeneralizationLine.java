package Line;

import BasicObject.Port;

import java.awt.*;

import static java.lang.Math.cos;

public class GeneralizationLine extends PolygonLine {
    public GeneralizationLine(Port start, Port end){
        super(start, end);
        corner_num = 3;
    }

}
