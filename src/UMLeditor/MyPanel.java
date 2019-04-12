package UMLeditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MyPanel extends JPanel {

    public MyPanel(){
//        setBorder(BorderFactory.createLineBorder(Color.black));
//        setBackground(Color.white);


    }
//    private void moveSquare(int x, int y){
//        int OFFSET = 1;
//        if ((squareX!=x) || squareY!=y){
//            repaint(squareX, squareY, squareW+OFFSET, squareH+OFFSET);
//            squareX=x;
//            squareY=y;
//            repaint(squareX, squareY, squareW+OFFSET, squareH+OFFSET);
//        }
//    }
    public Dimension getPreferredSize(){
        return new Dimension(900, 600);
    }
//    protected void paintComponent(Graphics g){
//        super.paintComponent(g);
//
//        g.drawString("This is my custom Panel !", 10, 20 );
//        g.setColor(Color.RED);
//        g.fillRect(squareX, squareY, squareW, squareH);
//        g.setColor(Color.RED);
//        g.drawRect(squareX, squareY, squareW, squareH);
//    }
}