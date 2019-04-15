package SwingSample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LabelActionListener implements ActionListener{
    JFrame f;
    JTextField tf;
    JLabel l;
    JButton b;
 LabelActionListener(){
     f = new JFrame();
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     tf = new JTextField();
     tf.setBounds(50, 50, 150, 20);
     l = new JLabel();
     l.setBounds(50, 100, 250, 20);
     b = new JButton("Find IP");
     b.setBounds(60, 150, 95, 30);
     b.addActionListener(this);
     f.add(tf);
     f.add(l);
     f.add(b);
     f.setSize(400, 400);
     f.setLayout(null);
     f.setVisible(true);

 }
 public void actionPerformed(ActionEvent e){
     try{
         String host = tf.getText();
         String ip = java.net.InetAddress.getByName(host).getHostAddress();
         l.setText("IP of "+host+" is "+ip);
     }catch(Exception ex){System.out.println(ex);}
 }

    public static void main(String[] args) {
        new LabelActionListener();
    }
}
