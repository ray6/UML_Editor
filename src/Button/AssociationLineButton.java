package Button;

import Mode.AssociationMode;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AssociationLineButton extends Button {
    public AssociationLineButton(Icon icon, int number){
        super(icon);
        no = number;
        myMode = new AssociationMode();
        Border emborder = BorderFactory.createEmptyBorder();
        setBackground(Color.white);
        setBorder(emborder);
    }

}
