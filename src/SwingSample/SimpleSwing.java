package SwingSample;
import javax.swing.JFrame;
import javax.swing.JButton;

public class SimpleSwing {
    public static void main(String[] args) {
        //creating instance of JFrame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //creating instance of JButton
        JButton button = new JButton("click");
        button.setBounds(0, 0, 100, 40);

        frame.add(button);

        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }


}
