/*
 * CS-112 L02
 * Java Project 2.
 * 28/04/2021
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;

/**
 * @author [Abdulrazaq 4020018]
 */
public class GUI implements ActionListener {
    private static JLabel userLabel,passwordLabel,messageLabel;
    private static JTextField userTextField;
    private static JPasswordField passwordField;
    private static JFrame frame;
    private static JPanel panel;
    private static JButton button;

    public void login() throws Exception {
        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(350, 180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Login ...");
        
        panel.setLayout(null);
        userLabel = new JLabel("User Name: ");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);
        
        userTextField = new JTextField();
        userTextField.setBounds(100, 20, 165, 25);
        panel.add(userTextField);
        
        passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 165, 25);
        panel.add(passwordField);

        button = new JButton("Login");
        button.setBounds(50, 90, 80, 25);
        button.addActionListener(new GUI());
        panel.add(button);

        messageLabel = new JLabel("");
        messageLabel.setBounds(150, 90, 150, 25);
        panel.add(messageLabel);
        
        
        
        frame.setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        // From the file user.txt

        String user = userTextField.getText();
        String password = passwordField.getText();
        if (user.equals("Car2") && password.equals("haha2")) {
            button.setEnabled(false);;
            secondGui();
            
        } else {
            messageLabel.setText("Incorrect Password.");
        }    
    }

    private void secondGui() {
        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(900, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Account");

        panel.setLayout(null);
        

        frame.setVisible(true);
    }
}
