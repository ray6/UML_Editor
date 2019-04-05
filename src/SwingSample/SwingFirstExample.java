package SwingSample;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SwingFirstExample{
    public static void main(String[] args) {
        JFrame frame = new JFrame("My First Swing Example");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel();
        // add panel to frame
        frame.add(panel);
        // user define method for adding components to the panel.
        placeComponents(panel);

        //setting the frame visibility to true
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        //set layer to null
        panel.setLayout(null);

        //creating Jlabel
        JLabel userLabel = new JLabel("User");
        //specifies the location and size of component.setBounds(x,y,w,h)
        //(x,y)for top left corner
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        //creating text field for enter user name.
        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userLabel);

        //password label
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 40, 80, 25);
        panel.add(passwordLabel);

        //password field (enter data and display dot instead)
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 40, 165, 25);
        panel.add(passwordLabel);

        //creting login button
        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);
    }
}
