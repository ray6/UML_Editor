package UMLeditor;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.Border;

public class UI extends JFrame {
    private JPanel canvas;
    private  JMenuBar jmb;
    private JMenu file;
    private  JMenu edit;
    private JMenuItem [] file_item = new JMenuItem[2];
    private  JMenuItem [] edit_item = new JMenuItem[3];
    private  JButton [] buttons = new JButton[6];
    private int ModeNO;


    public UI(){
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        canvas = new JPanel();
        canvas.setSize(900, 600);
        canvas.setBackground(Color.BLUE);

        initMenu();
        initButton();
        addComponentToPane();
        showGUI();
    }

    private void initMenu(){
        jmb = new JMenuBar();

        file = new JMenu("File");
        file_item[0] = new JMenuItem("1");
        file_item[1] = new JMenuItem("2");

        edit = new JMenu("Edit");
        edit_item[0] = new JMenuItem("change object name");
        edit_item[1] = new JMenuItem("group");
        edit_item[2] = new JMenuItem("ungroup");

        jmb.add(file);
        jmb.add(edit);
        file.add(file_item[0]);
        file.add(file_item[1]);
        edit.add(edit_item[0]);
        edit.add(edit_item[1]);
        edit.add(edit_item[2]);

    }
    private void initButton(){
        /*
        Button List :
           0 : Select,  1 : Association Line, 2 : Generalization Line
           3 : Composition Line,  4 : class,  5 : Use Case
        */
        String img_path = "C:\\Users\\ray\\IdeaProjects\\OOOO\\img\\";
        String [] img = {"arrow.png", "Line.png", "gen.png", "comp.png", "class.png", "use.png"};
        Border emborder = BorderFactory.createEmptyBorder();
        for(int i =0; i<6; i++){
            buttons[i] = new JButton(new ImageIcon(img_path+img[i]));
            buttons[i].setBackground(Color.white);
            buttons[i].setBorder(emborder);
        }
        buttons[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttons[4].setIcon(new ImageIcon(img_path+"class_R.png"));
                ClassMode();
            }
        });
    }
    private void addComponentToPane(){

        setJMenuBar(jmb);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(6, 1));
        for(int i =0; i<6 ; i++){
            p.add(buttons[i]);
        }
        add(p, BorderLayout.WEST);
        add(canvas, BorderLayout.CENTER);

    }
    private void showGUI(){
        pack();
        setVisible(true);
    }

    private void ClassMode(){
//        canvas.removeMouseListener();
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Class c = new Class();
                //c.setBounds(e.getX(), e.getY(), 80, 100);
//                c.setLocation(e.getX(), e.getY());
                System.out.println("X : " + e.getX() + "\nY :" + e.getY());
//                canvas.add(c);
                canvas.removeAll();
                canvas.revalidate();
                canvas.repaint();
//                addComponentToPane();
                canvas.add(c);
                c.repaint(e.getX(), e.getY())


            }
        });
    }


    public static void main(String[] args) {
        new UI();
    }
}

