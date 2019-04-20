package UMLeditor;

import BasicObject.Class;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.Border;

public class UI extends JFrame {
    private MyCanvas canvas;
    private  JMenuBar jmb;
    private JMenu file;
    private  JMenu edit;
    private JMenuItem [] file_item = new JMenuItem[2];
    private  JMenuItem [] edit_item = new JMenuItem[4];
    private  JButton [] buttons = new JButton[6];
    private Icon [][] icons = new ImageIcon[6][2];


    public UI(){
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        canvas = new MyCanvas();

        initMenu();
        initIcon();
        initButton();
        addComponentToPane();
        showGUI();
    }

    private void initMenu(){
        jmb = new JMenuBar();

        file = new JMenu("File");
        file_item[0] = new JMenuItem("Save");
        file_item[1] = new JMenuItem("Close");

        edit = new JMenu("Edit");
        edit_item[0] = new JMenuItem("Rename");
        edit_item[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (canvas.isSelecting()){
                    String name = JOptionPane.showInputDialog(
                            "Rename Object : ", null);
                    if ( name != null){
                        canvas.setSelectedName(name);
                    }
                }
            }
        });
        edit_item[1] = new JMenuItem("Group");
        edit_item[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (canvas.isSelecting()){
                    canvas.Group();
                }
            }
        });
        edit_item[2] = new JMenuItem("Ungroup");
        edit_item[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (canvas.isSelecting()){
                    canvas.UnGroup();
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
//        String img_path = "C:\\Users\\ray\\IdeaProjects\\OOOO\\img\\";
        String img_path = "./img/";
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
        Border emborder = BorderFactory.createEmptyBorder();
        for(int i =0; i<6; i++){
            buttons[i] = new JButton(icons[i][0]);
            buttons[i].setBackground(Color.white);
            buttons[i].setBorder(emborder);
        }
        AddSelectListener();
        AddASSListener();
        AddGENListener();
        AddCOMListener();
        AddClassListener();
        AddUseCaseListener();
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

    private void AddSelectListener() {
        //button[0] is SelectMode
        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchIcon(0);
                canvas.ModeSwitcher(0);
            }
        });
    }
    private void AddASSListener(){
        //button[1] is Association Line Mode
        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchIcon(1);
                canvas.ModeSwitcher(1);
            }
        });
    }
    private void AddGENListener(){
        //button[2] is Generalization Line Mode
        buttons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchIcon(2);
                canvas.ModeSwitcher(2);
            }
        });
    }
    private void AddCOMListener(){
        //button[3] is Composition Line
        buttons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchIcon(3);
                canvas.ModeSwitcher(3);
            }
        });
    }
    private void AddClassListener(){
        //button[4] is ClassMode
        buttons[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchIcon(4);
                canvas.ModeSwitcher(4);
            }
        });
    }
    private void AddUseCaseListener(){
        //button[5] is Use Case Mode
        buttons[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchIcon(5);
                canvas.ModeSwitcher(5);
            }
        });
    }

    private void switchIcon(int no){
        for (int i =0; i<6;i++){
            buttons[i].setIcon(icons[i][i==no ? 1 : 0]);
        }
    }


    public static void main(String[] args) {
        new UI();
    }
}

