package Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Mode.Mode;
import UMLeditor.MyCanvas;
import UMLeditor.UI;

public abstract class Button extends JButton implements ActionListener {
    Mode myMode;
    int no;
    public Button(Icon icon){
        super(icon);
        addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        UI.getInstance().switchIcon(no);
        MyCanvas.getInstance().ModeSwitcher(myMode);
    }
}
