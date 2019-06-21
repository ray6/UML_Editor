package Button;

import Mode.UseCaseMode;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class UseCaseButton extends Button {

    public UseCaseButton(Icon icon, int number){
        super(icon);
        no = number;
        myMode = new UseCaseMode();
        Border emborder = BorderFactory.createEmptyBorder();
        setBackground(Color.white);
        setBorder(emborder);
    }

}
