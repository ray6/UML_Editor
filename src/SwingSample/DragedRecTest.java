package SwingSample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DragedRecTest {
    DragedRecTest(){
        JFrame f = new JFrame();
        f.setSize(1000, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jpanel p = new jpanel();
        p.setPreferredSize(new Dimension(1000, 600));
        f.add(p);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new DragedRecTest();
    }

    private void draw(Graphics g){

    }
}

class jpanel extends JPanel{
    int X;
    int Y;
    int W;
    int H;
    public jpanel(){
        setBorder(BorderFactory.createLineBorder(Color.black));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("press");
                X = e.getX();
                Y = e.getY();
                drawRec(e.getX(), e.getY());
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println("dragged");
                drawRec(e.getX(), e.getY());
            }
        });
    }
    private void drawRec(int x, int y){
        repaint();
        W = x - X;
        H = y - Y;
        repaint();
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.drawRect(X, Y, W, H);

    }
}