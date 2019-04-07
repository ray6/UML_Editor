package UMLeditor;
import javax.swing.*;

public class UI{
    JFrame frame;
    JButton b_file, b_edit;
    JButton b_select, b_assline, b_genline, b_comline, b_class, b_usercase;

    UI(){
        frame = new JFrame("UML Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b_file = new JButton("File");
        b_edit = new JButton("Edit");
        b_file.setBounds(0,0,20, 10);
        b_edit.setBounds(20,0,20, 10);

        b_select = new JButton(new ImageIcon("/Users/RayLiu/IdeaProjects/OOOO/img/rabbit.png"));
        b_assline= new JButton(new ImageIcon("/Users/RayLiu/IdeaProjects/OOOO/img/rabbit.png"));
        b_genline = new JButton(new ImageIcon("/Users/RayLiu/IdeaProjects/OOOO/img/rabbit.png"));
        b_comline = new JButton(new ImageIcon("/Users/RayLiu/IdeaProjects/OOOO/img/rabbit.png"));
        b_class = new JButton(new ImageIcon("/Users/RayLiu/IdeaProjects/OOOO/img/rabbit.png"));
        b_usercase = new JButton(new ImageIcon("/Users/RayLiu/IdeaProjects/OOOO/img/rabbit.png"));
        b_select.setBounds(0,10, 50, 50);
        b_assline.setBounds(0,60, 50, 50);
        b_genline.setBounds(0,110, 50, 50);
        b_comline.setBounds(0,170, 50, 50);
        b_class.setBounds(0,220, 50, 50);
        b_usercase.setBounds(0,270, 50, 50);

        frame.add(b_file);
        frame.add(b_edit);
        frame.add(b_select);
        frame.add(b_assline);
        frame.add(b_genline);
        frame.add(b_comline);
        frame.add(b_class);
        frame.add(b_usercase);

        frame.setLayout(null);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new UI();
    }
}
