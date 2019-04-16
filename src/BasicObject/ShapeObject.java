package BasicObject;

import BasicObject.BasicObject;

public abstract class ShapeObject extends BasicObject {
    //Position
    protected int X;
    protected int Y;
    protected int W;
    protected int H;

    //Connection port
    protected Port North;
    protected Port South;
    protected Port WEST;
    protected Port EAST;

}

