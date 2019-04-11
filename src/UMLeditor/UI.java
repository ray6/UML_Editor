package UMLeditor;

import java.awt.*;
import javax.swing.*;

public class UI extends JFrame {
    private Canvas canvas;
    private  JMenuBar jmb;
    private JMenu file;
    private  JMenu edit;
    private JMenuItem [] file_item = new JMenuItem[2];
    private  JMenuItem [] edit_item = new JMenuItem[3];
    private  JButton [] buttons = new JButton[6];

    public UI(){
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initMenu();
        initButton();
        addComponentToPane(this.getContentPane());

        setResizable(true);
        pack();
        setVisible(true);
    }
    private void initMenu(){
        jmb = new JMenuBar();
        setJMenuBar(jmb);

        file = new JMenu("File");
        jmb.add(file);
        file_item[0] = new JMenuItem("1");
        file_item[1] = new JMenuItem("2");
        file.add(file_item[0]);
        file.add(file_item[1]);

        edit = new JMenu("Edit");
        jmb.add(edit);
        edit_item[0] = new JMenuItem("change object name");
        edit_item[1] = new JMenuItem("group");
        edit_item[2] = new JMenuItem("ungroup");
        edit.add(edit_item[0]);
        edit.add(edit_item[1]);
        edit.add(edit_item[2]);
    }

    private void initButton(){
        String img_path = "C:\\Users\\ray\\IdeaProjects\\OOOO\\img\\";
        String [] img = {"arrow.png", "Line.png", "gen.png", "comp.png", "class.png", "use.png"};
        for(int i =0; i<6; i++){
            buttons[i] = new JButton(new ImageIcon(img_path+img[i]));
            buttons[i].setBackground(Color.white);
        }
    }
    public void addComponentToPane(Container pane){

        pane.setLayout(new BorderLayout());
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(6, 1));

        for(int i =0; i<6 ; i++){
            p.add(buttons[i]);
        }
        add(p, BorderLayout.WEST);
        p = new MyCanvas();
        add(p, BorderLayout.CENTER);

    }


    public static void main(String[] args) {
        new UI();
    }
}

