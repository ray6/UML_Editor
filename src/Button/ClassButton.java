package Button;

import Mode.ClassMode;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ClassButton extends Button {
    public ClassButton(Icon icon, int number){
        super(icon);
        no = number;
        myMode = new ClassMode();
        Border emborder = BorderFactory.createEmptyBorder();
        setBackground(Color.white);
        setBorder(emborder);
    }
}
