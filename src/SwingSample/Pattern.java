package SwingSample;
import UMLeditor.Port;

import javax.swing.*;

public class Pattern extends JPanel{

    private int depth;

    private Port NOUTH;
    private Port SOUTH;
    private Port WEST;
    private Port EAST;

    public Pattern(){
        depth = 50;
        NOUTH = new Port();
        SOUTH = new Port();
        WEST = new Port();
        EAST = new Port();

    }

}

