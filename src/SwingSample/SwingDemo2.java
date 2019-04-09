package SwingSample;
import com.sun.javaws.util.JfxHelper;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class SwingDemo2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShoeGui();
            }
        });
    }
    private static void createAndShoeGui(){
        System.out.println("Create on EDT ? " + SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MyPanel1());
        f.pack();
        f.setVisible(true);
    }
}
class MyPanel1 extends JPanel{
    public MyPanel1(){
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
    public Dimension getPreferredSize(){
        return new Dimension(250, 200);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawString("This is my custom Panel !", 10, 20 );
    }
}
