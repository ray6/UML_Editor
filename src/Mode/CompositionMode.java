package Mode;

import BasicObject.Port;
import Line.Line;
import Line.CompositionLine;

public class CompositionMode extends ConnectMode {

    @Override
    protected Line NewConnect(Port start, Port end) {
        return new CompositionLine(start, end);
    }
}
