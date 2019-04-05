package SwingSample;
import javax.swing.JFrame;
import javax.swing.JButton;
public class InheritingSwing extends JFrame{
    JFrame frame;
    InheritingSwing(){
        JButton button = new JButton("click");
        button.setBounds(130, 100, 100, 40);

        add(button);
        setSize(400, 500);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new InheritingSwing();
    }
}
