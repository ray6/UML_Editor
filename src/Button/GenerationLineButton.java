package Button;

import Mode.GeneralizationMode;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GenerationLineButton extends Button {

    public GenerationLineButton(Icon icon, int number){
        super(icon);
        no = number;
        myMode = new GeneralizationMode();
        Border emborder = BorderFactory.createEmptyBorder();
        setBackground(Color.white);
        setBorder(emborder);
    }

}
