package Button;

import Mode.SelectMode;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SelectButton extends Button {

    public SelectButton(Icon icon, int number){
        super(icon);
        no = number;
        myMode = new SelectMode();
        Border emborder = BorderFactory.createEmptyBorder();
        setBackground(Color.white);
        setBorder(emborder);
    }
}
