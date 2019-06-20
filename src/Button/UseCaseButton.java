package Button;

import UMLeditor.MyCanvas;
import UMLeditor.UI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UseCaseButton extends JButton implements ActionListener {
    int no;
    public UseCaseButton(Icon icon, int number){
        super(icon);
        no = number;
        Border emborder = BorderFactory.createEmptyBorder();
        setBackground(Color.white);
        setBorder(emborder);
        addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        UI.getInstance().switchIcon(no);
        MyCanvas.getInstance().ModeSwitcher(no);
    }
}
