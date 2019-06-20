package Mode;

import BasicObject.BasicObject;
import BasicObject.Port;
import Line.Line;
import UMLeditor.MyCanvas;

import java.awt.event.MouseEvent;

public abstract class ConnectMode extends Mode {
    protected boolean Connecting;
    protected int X1, Y1, X2, Y2;
    protected BasicObject start_obj, end_obj;
    protected Port start_port, end_port;

    @Override
    public void mousePressed(MouseEvent e) {
        X1 = e.getX();
        Y1 = e.getY();
        start_obj = MyCanvas.getInstance().getComponent(X1, Y1);
        if (start_obj != null){
            start_port = start_obj.getConnectPort(X1, Y1);
            if (start_port != null){
                MyCanvas.getInstance().setL_start(start_port.getX(), start_port.getY());
                Connecting = true;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (Connecting){
            Connecting = false;
            MyCanvas.getInstance().clearL();
            X2 = e.getX();
            Y2 = e.getY();
            end_obj = MyCanvas.getInstance().getComponent(X2, Y2);
            if (end_obj != null && start_obj!=end_obj){
                end_port = end_obj.getConnectPort(X2, Y2);
                if (end_port != null){
                    MyCanvas.getInstance().AddToLineList(NewConnect(start_port, end_port));
                }
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (Connecting){
            MyCanvas.getInstance().setL_end(e.getX(), e.getY());
        }
    }

    protected abstract Line NewConnect(Port start, Port end);
}
