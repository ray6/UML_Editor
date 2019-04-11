package UMLeditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class UI extends  JFrame{
    private Canvas mycanvas = new Canvas();
    private JMenuBar jmb;
    private JMenu file = new JMenu("File");
    private JMenu edit = new JMenu("Edit");
    private JMenuItem [] file_item = new JMenuItem[3];//選單1
    private JMenuItem [] edit_item = new JMenuItem[3];//選單2
    private JButton[] btns = new JButton[6];

    public UI(){
        init();
        initMenu();
        initButton();

    }
    private void init() {
        // TODO Auto-generated method stub
        this.setLayout(null);
        this.add(mycanvas);
        this.setSize(1000,600);
        this.setLocation(50,10);
        this.setResizable(false);//視窗放大按鈕無效
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void initMenu() {
        // TODO Auto-generated method stub
        jmb = new JMenuBar();
        this.setJMenuBar(jmb); //加入工具列
        //遊戲的選擇項目
        jmb.add(file);
        file_item[0] = new JMenuItem("1");
        file_item[1] = new JMenuItem("2");
        file.add(file_item[0]);
        file.add(file_item[1]);
        //關於的選擇項目
        jmb.add(edit);
        edit_item[0] = new JMenuItem("change object name");
        edit_item[1] = new JMenuItem("group");
        edit_item[2] = new JMenuItem("ungroup");
        edit.add(edit_item[0]);
        edit.add(edit_item[1]);
        edit.add(edit_item[2]);

    }
    private void initButton() {
        // TODO Auto-generated method stub
        int totaly=5;
        for(int i=0;i<=5;i++)
        {
            btns[i]=new JButton();
            Icon imgicon = new ImageIcon("res/"+String.valueOf(i+1)+".png");
            btns[i].setIcon(imgicon);
            this.add(btns[i]);
            btns[i].setBounds(10, totaly, 50, 50);
            totaly=totaly+65;

        }
    }

    public static void main(String[] args) {
        new UI();
    }
}

