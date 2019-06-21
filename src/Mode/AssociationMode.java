package Mode;

import Shape.Port;
import Line.Line;
import Line.AssociationLine;

public class AssociationMode extends ConnectMode {
    @Override
    protected Line NewConnect(Port start, Port end) {
        return new AssociationLine(start, end);
    }
}
