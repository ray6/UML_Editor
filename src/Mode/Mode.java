package Mode;

import UMLeditor.MyCanvas;

import javax.swing.*;
import java.awt.event.MouseAdapter;

public abstract class Mode extends MouseAdapter {
    protected MyCanvas canvas;
    public Mode(MyCanvas canvas){
        super();
        this.canvas = canvas;
    }
}
