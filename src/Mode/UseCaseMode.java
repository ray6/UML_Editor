package Mode;

import BasicObject.UseCase;
import UMLeditor.MyCanvas;

import java.awt.event.MouseEvent;

public class UseCaseMode extends CreateMode {
    public UseCaseMode(MyCanvas canvas){
        super(canvas);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        canvas.AddToComponentList(new UseCase(e.getX(), e.getY()));
    }
}
