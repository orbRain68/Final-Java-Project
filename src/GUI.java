/*
 * CS-112 L02
 * Java Project 2.
 * 28/04/2021
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.*;
import javax.swing.border.Border;

/**
 * @author [Abdulrazaq 4020018]
 */
public class GUI extends bank implements ActionListener {
    private static JLabel userLabel,passwordLabel,messageLabel;
    private static JTextField userTextField;
    private static JPasswordField passwordField;
    private static JFrame frame;
    private static JPanel panel;
    private static JButton button;
    private static bank obj = new bank();
    public static String accountNumber;


    public static void login() throws Exception {
        frame = createFrame();

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        
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
        button.addActionListener(new GUI() {
                
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        // From the file user.txt

        String user = userTextField.getText();
        String password = passwordField.getText();
        try {
            Enumeration<String> keys = obj.IHaveNoIdea().keys();
            String [] accounts = new String[3];
            int i = 0;
            while (keys.hasMoreElements()) {
                accounts[i] = keys.nextElement();
                i++;
            }
            if (user.equals(obj.IHaveNoIdea().get(accounts[0])[0]) && password.equals(obj.IHaveNoIdea().get(accounts[0])[1])) {
                //int acount = Integer.parseInt(accounts[0]);
                obj.setAccountNumber(accounts[0]) ;
                GUI.accountNumber = obj.getAccountNumber();
                System.out.println(accountNumber);
                secondGui();
            } else if (user.equals(obj.IHaveNoIdea().get(accounts[1])[0]) && password.equals(obj.IHaveNoIdea().get(accounts[1])[1])) {
                //int acount = Integer.parseInt(accounts[1]);
                obj.setAccountNumber(accounts[1]) ;
                GUI.accountNumber = obj.getAccountNumber();
                System.out.println(accountNumber);
                secondGui();
            } else if (user.equals(obj.IHaveNoIdea().get(accounts[2])[0]) && password.equals(obj.IHaveNoIdea().get(accounts[2])[1])) {
                //int acount = Integer.parseInt(accounts[2]);
                obj.setAccountNumber(accounts[2]);
                GUI.accountNumber = obj.getAccountNumber();
                System.out.println(accountNumber);
                secondGui();
            } else {
                messageLabel.setText("Incorrect Password.");
                System.out.println(accountNumber);
            }
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            System.out.println("check for missing file (BankUsers.txt)");
            e1.printStackTrace();
        }    
    }
        });
        panel.add(button);

        messageLabel = new JLabel("");
        messageLabel.setBounds(150, 90, 150, 25);
        panel.add(messageLabel);
        
        
        
        frame.setVisible(true);
        
        
    }



    private static void secondGui() {
        frame.setVisible(false);
        JFrame frame1 = createFrame2();
        JPanel buttonPanel = new JPanel();
        JLayeredPane layeredPane = new JLayeredPane();
        JPanel homePanel = homPanel();
        JPanel withdrawPanel = withdrawPanel();
        JPanel depositPanel = depositPanel();


        buttonPanel.setBounds(0, 0, 632, 70);
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Services"));
        JButton homeButton = new JButton("Home");
        homeButton.addActionListener(new GUI() {
            public void actionPerformed(ActionEvent e) {
                layeredPane.removeAll();
                layeredPane.add(homePanel);
                layeredPane.repaint();
                layeredPane.revalidate();
            }
        });
        buttonPanel.add(homeButton);
        JButton withdrawSwitchButton = new JButton("Withdraw");
        withdrawSwitchButton.addActionListener(new GUI() {
            public void actionPerformed(ActionEvent e) {
                layeredPane.removeAll();
                layeredPane.add(withdrawPanel);
                layeredPane.repaint();
                layeredPane.revalidate();
            }
        });
        buttonPanel.add(withdrawSwitchButton);
        JButton depositSwitchButton = new JButton("deposit");
        buttonPanel.add(depositSwitchButton);
        depositSwitchButton.addActionListener(new GUI() {
            public void actionPerformed(ActionEvent e) {
                layeredPane.removeAll();
                layeredPane.add(depositPanel);
                layeredPane.repaint();
                layeredPane.revalidate();
            }
        });
        frame1.add(buttonPanel);
        
        layeredPane.setBounds(2,70,630,290);
        layeredPane.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        layeredPane.setLayout(null);
        JLabel welcomeLabel = new JLabel("Welcome to our bank!");
        JLabel acountLabel = new JLabel("Your acount number is: " + GUI.accountNumber);
        JLabel balanceLabel = new JLabel("Your balance is: ");
        
        layeredPane.add(homePanel);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBounds(155, 5, 185, 25);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        
        // set a text for acount number (Integer To string)
        acountLabel.setBounds(100, 40, 300, 25);
        acountLabel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));

        // set a text for Balance (Double to String)
        balanceLabel.setBounds(100, 75, 300, 25);
        balanceLabel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));

        homePanel.add(welcomeLabel);
        homePanel.add(acountLabel);
        homePanel.add(balanceLabel);

        JLabel withdrawText = new JLabel("Enter an amount to withdraw");
        withdrawText.setBounds(155, 5, 185, 25);
        withdrawText.setHorizontalAlignment(JLabel.CENTER);
        withdrawPanel.add(withdrawText);

        JTextField withdrawAmount = new JTextField();
        withdrawAmount.setBounds(100, 45, 300, 25);
        withdrawPanel.add(withdrawAmount);

        JLabel messagewithdrawLabel = new JLabel("");
        messagewithdrawLabel.setBounds(100, 75, 300, 25);
        withdrawPanel.add(messagewithdrawLabel);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(50, 125, 130, 20);
        withdrawButton.addActionListener(new GUI() {
            public void actionPerformed(ActionEvent e) {
                String successful = "Money was sent to your physical wallet :)";
                String fails = "Invalid input";
                String input = withdrawAmount.getText();
                if (isNumeric(input)) {
                    messagewithdrawLabel.setText(successful);
                    withdrawAmount.setText("");
                    // Add to balance function.
                } else {
                    messagewithdrawLabel.setText(fails);
                    withdrawAmount.setText("");

                }
            }
        });
        withdrawPanel.add(withdrawButton);

        JLabel depositText = new JLabel("Enter an amount to deposit");
        depositText.setBounds(155, 5, 185, 25);
        depositText.setHorizontalAlignment(JLabel.CENTER);
        depositPanel.add(depositText);

        JTextField depositAmount = new JTextField();
        depositAmount.setBounds(100, 45, 300, 25);
        depositPanel.add(depositAmount);

        JLabel messagedepositLabel = new JLabel("");
        messagedepositLabel.setBounds(100, 75, 300, 25);
        depositPanel.add(messagedepositLabel);

        JButton depositButton = new JButton("deposit");
        depositButton.setBounds(50, 125, 130, 20);
        depositButton.addActionListener(new GUI() {
            public void actionPerformed(ActionEvent e) {
                String successful = "Money has been added to your balance";
                String fails = "Invalid input";
                String input = depositAmount.getText();
                if (isNumeric(input)) {
                    messagedepositLabel.setText(successful);
                    depositAmount.setText("");
                    // Add to balance function.
                } else {
                    messagedepositLabel.setText(fails);
                    depositAmount.setText("");

                }
            }
        });
        depositPanel.add(depositButton);

        frame1.add(layeredPane);
        frame1.setVisible(true);
    }
    private static JPanel depositPanel() {
        JPanel depositPanel = new JPanel();
        depositPanel.setBounds(65, 45, 500, 200);
        depositPanel.setLayout(null);
        depositPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        return depositPanel;
    }

    private static JPanel withdrawPanel() {
        JPanel withdrawPanel = new JPanel();
        withdrawPanel.setBounds(65, 45, 500, 200);
        withdrawPanel.setLayout(null);
        withdrawPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        return withdrawPanel;
    }

    private static JFrame createFrame2() {
        JFrame frame = new JFrame("Account");
        frame.setSize(new Dimension(650,400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        return frame;
    }
    private static JFrame createFrame() {
        JFrame frame = new JFrame("Login ...");
        frame.setSize(new Dimension(350, 180));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        return frame;
    }
    private static JPanel homPanel() {
        JPanel homePanel = new JPanel();
        homePanel.setBounds(65, 45, 500, 200);
        homePanel.setLayout(null);
        homePanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        return homePanel;
    }
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
      }
      public static void main(String[] args) throws Exception {
        login();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
