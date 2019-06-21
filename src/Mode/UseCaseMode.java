package Mode;

import Shape.UseCase;
import UMLeditor.MyCanvas;

import java.awt.event.MouseEvent;

public class UseCaseMode extends Mode {
    @Override
    public void mousePressed(MouseEvent e) {
        MyCanvas.getInstance().AddToComponentList(new UseCase(e.getX(), e.getY()));
    }
}
