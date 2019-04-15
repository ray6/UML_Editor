package UMLeditor;

import java.awt.*;

public abstract class ShapeObject extends BasicObject {
    //Position
    private int X;
    private int Y;
    private int W;
    private int H;

    //Connection port
    private Port North;
    private Port South;
    private Port WEST;
    private Port EAST;

}

