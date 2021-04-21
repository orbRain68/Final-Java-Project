/*
 * CS-112 L02
 * Java Project 2.
 * 28/04/2021
 */
import java.util.Arrays;
import javax.swing.*;
/**
 * @author [Abdulrazaq 4020018]
 */
public class GUI {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(350, 180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Login ...");
        
        panel.setLayout(null);
        JLabel userLabel = new JLabel("User Name: ");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);
        
        JTextField userTextField = new JTextField();
        userTextField.setBounds(100, 20, 165, 25);
        panel.add(userTextField);
        
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);
        
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 165, 25);
        panel.add(passwordField);

        JButton button = new JButton("Login");
        button.setBounds(50, 90, 80, 25);
        panel.add(button);

        JLabel messageLabel = new JLabel("Incorrect Password.");
        messageLabel.setBounds(150, 90, 150, 25);
        panel.add(messageLabel);
        
        
        
        frame.setVisible(true);
        
        
        System.out.println("Hello, World!");
    }
}
