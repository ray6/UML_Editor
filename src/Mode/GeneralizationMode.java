package Mode;

import BasicObject.Port;
import Line.Line;
import Line.GeneralizationLine;

public class GeneralizationMode extends ConnectMode {

    @Override
    protected Line NewConnect(Port start, Port end) {
        return new GeneralizationLine(start, end);
    }
}
