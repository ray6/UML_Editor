package UMLeditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyCanvas extends JPanel implements KeyListener, MouseListener{
    Canvas c;
    JTextField tf;
    String s;
    public MyCanvas(){
        c = new Canvas();
        tf = new JTextField();
        c.addKeyListener(this);
        c.addMouseListener(this);

        add(c);
        add(tf);


    }

    public static void main(String[] args) {
        MyCanvas mc = new MyCanvas();
        JFrame f = new JFrame("Canvas");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(mc);

        f.setSize(300, 150);
        f.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        tf.setText("key pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        tf.setText("key released");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        tf.setText("Key Typed");
        s += e.getKeyChar();
        c.getGraphics().drawString(s, 0, 20);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        tf.setText("Mouse Clicked");
        c.requestFocus();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        tf.setText("Mouse Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        tf.setText("Mouse Exited");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        tf.setText("Mouse Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        tf.setText("Mouse Release");
    }
    public void mouseDragged(java.awt.event.MouseEvent e){
        tf.setText("mouse Dragged");
    }
    public void mouseMoved(java.awt.event.MouseEvent e){
        tf.setText("mouse Moved");

    }
}