package UMLeditor;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class Class extends Pattern {
    private String class_name = "Class";
    private JLabel namelb;
    private JTextField nametf;
    private JPanel emptyP1;
    private JPanel emptyP2;
    private Color bgcolor = Color.PINK; //background color
    private Color bdcolor = Color.BLACK; //border color

    public Class(){
        super();
//        setSize(80, 100);
        setLayout(new GridLayout(3,1));
        namelb = new JLabel(class_name, SwingConstants.CENTER);
        namelb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ChangeClassName();
            }
        });
        nametf = new JTextField(class_name);
        nametf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    SetNewClassName(nametf.getText());
                }
            }
        });
        emptyP1 = new JPanel();
        emptyP1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SetNewClassName(nametf.getText());
            }
        });
        emptyP2 = new JPanel();
        emptyP2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SetNewClassName(nametf.getText());
            }
        });

        addLabeltoPane();
        addEmptyPToPane();
    }
    public Class(String n){
        this();
        class_name = n;
        namelb.setText(class_name);
    }

    private void addEmptyPToPane(){
        Border boarder = BorderFactory.createLineBorder(bdcolor, 2);

        // Add empty panel
        emptyP1.setBorder(boarder);
        emptyP1.setBackground(bgcolor);
        add(emptyP1);

        // Add class empty panel
        emptyP2.setBorder(boarder);
        emptyP2.setBackground(bgcolor);
        add(emptyP2);
    }
    private void addLabeltoPane(){
        Border boarder = BorderFactory.createLineBorder(bdcolor, 2);
        // Add class name label
        namelb.setText(class_name);
        namelb.setBorder(boarder);
        namelb.setOpaque(true);
        namelb.setBackground(bgcolor);
        add(namelb);
    }
    private void addTextFieldtoPane(){
        Border boarder = BorderFactory.createLineBorder(bdcolor, 2);
        // Add class name label
        nametf.setText(class_name);
        nametf.setBorder(boarder);
        nametf.setOpaque(true);
        nametf.setBackground(bgcolor);
        add(nametf);
    }
    private void ChangeClassName(){
        removeAll();
        revalidate();
        repaint();
        addTextFieldtoPane();
        addEmptyPToPane();
    }
    private void SetNewClassName(String n){
        class_name = n;

        removeAll();
        revalidate();
        repaint();
        addLabeltoPane();
        addEmptyPToPane();
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(200,200);
        f.setLayout(null);
//        Class c = new Class();
//        f.add(c);
        Class c = new Class("Dog");
        f.add(c);
        f.setVisible(true);
    }

}
