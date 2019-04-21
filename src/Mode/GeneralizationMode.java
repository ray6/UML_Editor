package Mode;

import BasicObject.Port;
import Line.Line;
import Line.GeneralizationLine;
import UMLeditor.MyCanvas;

public class GeneralizationMode extends ConnectMode {
    public GeneralizationMode(MyCanvas canvas){
        super(canvas);
    }

    @Override
    protected Line NewConnect(Port start, Port end) {
        return new GeneralizationLine(start, end);
    }
}
