package SwingSample;
import javax.swing.*;

public class ImageButton {
    ImageButton(){
        JFrame f = new JFrame("Image button");
        JButton b = new JButton(new ImageIcon("C:\\Users\\ray\\Desktop\\save.jpg"));
        b.setBounds(60, 60, 188, 188);
        f.add(b);
        f.setSize(300, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ImageButton();
    }
}
