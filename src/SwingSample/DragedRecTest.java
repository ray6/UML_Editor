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
        f.pack();
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new DragedRecTest();
    }

    private void draw(Graphics g){

    }
}

class jpanel extends JPanel{
    int x1=0;
    int y1=0;
    int x2=0;
    int y2=0;
    int X =0;
    int Y = 0;
    int W = 0;
    int H = 0;
    public jpanel(){
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(Color.white);
        setPreferredSize(new Dimension(1000, 600));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("press");
                x1 = e.getX();
                y1 = e.getY();
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println("dragged");
                x2 = e.getX();
                y2 = e.getY();
                setRec();
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();
                setRec();
            }
        });
    }
    private void setRec(){
        repaint();
        X = Math.min(x1, x2);
        Y = Math.min(y1, y2);
        W = Math.abs(x1-x2);
        H = Math.abs(y1-y2);
        repaint();
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.drawRect(X, Y, W, H);

    }
}