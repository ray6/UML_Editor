package SwingSample;
import javax.swing.JFrame;
import java.awt.*;

public class Swing2Example {
    public static void main(String[] args) {

        // JFrame is main container of swing
        // consist of many panel
        JFrame frame = new JFrame();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container cp = frame.getContentPane();
    }
}
