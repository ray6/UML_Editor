package SwingSample;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionListener {
    public static void main(String[] args) {
        JFrame f = new JFrame("Action Listener");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTextField tf = new JTextField();
        tf.setBounds(50, 50, 150, 20);
        JButton b = new JButton("Click");
        b.setBounds(50, 100, 95, 30);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText("Hello World!");
            }
        });
        f.add(b);
        f.add(tf);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);

    }
}
