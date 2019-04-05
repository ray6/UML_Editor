package SwingSample;
import javax.swing.JFrame;
import javax.swing.JButton;

public class InsideConstructorSwing {
    JFrame frame;
    InsideConstructorSwing(){
        //creating instance of JFrame
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("click");
        button.setBounds(130, 100, 100, 40);

        frame.add(button);
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new InsideConstructorSwing();
    }
}
