package Button;

import Mode.CompositionMode;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CompositionLineButton extends Button {

    public CompositionLineButton(Icon icon, int number){
        super(icon);
        no = number;
        myMode = new CompositionMode();
        Border emborder = BorderFactory.createEmptyBorder();
        setBackground(Color.white);
        setBorder(emborder);
    }

}
