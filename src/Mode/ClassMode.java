package Mode;

import UMLeditor.MyCanvas;

import java.awt.event.MouseEvent;
import BasicObject.Class;

public class ClassMode extends CreateMode {
    public ClassMode(MyCanvas canvas){
        super(canvas);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        canvas.AddToComponentList(new Class(e.getX(), e.getY()));
    }
}
