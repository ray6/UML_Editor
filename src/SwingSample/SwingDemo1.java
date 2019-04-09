package SwingSample;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;

public class SwingDemo1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createandshowGUI();
            }
        });
    }
    private static void createandshowGUI(){
        System.out.println("Create GUI on EDT?"+SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(250, 200);
        f.setVisible(true);
    }
}
