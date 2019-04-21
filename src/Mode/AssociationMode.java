package Mode;

import BasicObject.Port;
import Line.Line;
import Line.AssociationLine;
import UMLeditor.MyCanvas;

public class AssociationMode extends ConnectMode {
    public AssociationMode(MyCanvas canvas){
        super(canvas);
    }

    @Override
    protected Line NewConnect(Port start, Port end) {
        return new AssociationLine(start, end);
    }
}
