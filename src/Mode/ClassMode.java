package Mode;

import UMLeditor.MyCanvas;

import java.awt.event.MouseEvent;
import Shape.Class;

public class ClassMode extends Mode {

    @Override
    public void mousePressed(MouseEvent e) {
        MyCanvas.getInstance().AddToComponentList(new Class(e.getX(), e.getY()));
    }
}
