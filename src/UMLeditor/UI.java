package UMLeditor;

import BasicObject.Class;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Button.*;

public class UI extends JFrame {
    private static UI ui;
    private  JMenuBar jmb;
    private JMenuItem [] file_item = new JMenuItem[2];
    private  JMenuItem [] edit_item = new JMenuItem[4];
    private  JButton [] buttons = new JButton[6];
    private Icon [][] icons = new ImageIcon[6][2];


    private UI(){
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        initMenu();
        initIcon();
        initButton();
        addComponentToPane();
        showGUI();
    }
    public static UI getInstance(){
        if (ui == null){
            ui = new UI();
        }
        return ui;
    }

    private void initMenu(){
        jmb = new JMenuBar();

        JMenu file = new JMenu("File");
        file_item[0] = new JMenuItem("Save");
        file_item[1] = new JMenuItem("Close");

        JMenu edit = new JMenu("Edit");
        edit_item[0] = new JMenuItem("Rename");
        edit_item[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MyCanvas.getInstance().isSelecting()){
                    String name = JOptionPane.showInputDialog(
                            "Rename Object : ", null);
                    if ( name != null){
                        MyCanvas.getInstance().setSelectedName(name);
                    }
                }
            }
        });
        edit_item[1] = new JMenuItem("Group");
        edit_item[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MyCanvas.getInstance().isSelecting()){
                    MyCanvas.getInstance().Group();
                }
            }
        });
        edit_item[2] = new JMenuItem("Ungroup");
        edit_item[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MyCanvas.getInstance().isSelecting()){
                    MyCanvas.getInstance().UnGroup();
                }
            }
        });
        edit_item[3] = new JMenuItem("Clear Canvas");

        jmb.add(file);
        jmb.add(edit);
        file.add(file_item[0]);
        file.add(file_item[1]);
        edit.add(edit_item[0]);
        edit.add(edit_item[1]);
        edit.add(edit_item[2]);

    }
    private void initIcon(){
        String img_path = "C:\\Users\\ray\\IdeaProjects\\OOOO\\img\\";
//        String img_path = "./img/";
        String [] img = {"arrow", "Line", "gen", "comp", "class", "use"};

        for (int i =0; i < 6; i++){
            icons[i][0]  = new ImageIcon(img_path+img[i]+".png");
            icons[i][1]  = new ImageIcon(img_path+img[i]+"_R.png");
        }
//        Image cc = Toolkit.getDefaultToolkit().getImage(img_path+img[0]+".png");
//        setIconImage(cc);
    }
    private void initButton(){
        /*
        Button List :
           0 : Select,  1 : Association Line, 2 : Generalization Line
           3 : Composition Line,  4 : class,  5 : Use Case
        */
        buttons[0] = new SelectButton(icons[0][0], 0);
        buttons[1] = new AssociationLineButton(icons[1][0], 1);
        buttons[2] = new GenerationLineButton(icons[2][0], 2);
        buttons[3] = new CompositionLineButton(icons[3][0], 3);
        buttons[4] = new ClassButton(icons[4][0], 4);
        buttons[5] = new UseCaseButton(icons[5][0], 5);
    }
    private void addComponentToPane(){

        setJMenuBar(jmb);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(6, 1));
        for(int i =0; i<6 ; i++){
            p.add(buttons[i]);
        }
        add(p, BorderLayout.WEST);
        add(MyCanvas.getInstance(), BorderLayout.CENTER);

    }
    private void showGUI(){
        pack();
        setVisible(true);
    }
    public void switchIcon(int no){
        for (int i =0; i<6;i++){
            buttons[i].setIcon(icons[i][i==no ? 1 : 0]);
        }
    }

    public static void main(String[] args) {
        UI.getInstance();
    }
}

