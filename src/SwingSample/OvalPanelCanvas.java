package SwingSample;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class OvalPanelCanvas extends JPanel {
    public OvalPanelCanvas() {
    }
    public void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        g.setColor(Color.black);
        g.drawOval(0, 0, width, height);
    }
    public static void main(String args[]) {
        JFrame frame = new JFrame("Oval Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new OvalPanelCanvas());
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}