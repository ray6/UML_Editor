package Mode;

import BasicObject.Port;
import Line.Line;
import Line.CompositionLine;
import UMLeditor.MyCanvas;

public class CompositionMode extends ConnectMode {
    public CompositionMode(MyCanvas canvas){
        super(canvas);
    }

    @Override
    protected Line NewConnect(Port start, Port end) {
        return new CompositionLine(start, end);
    }
}
