/*
 * CS-112 L02
 * Java Project 2.
 * 28/04/2021
 */
// Packages uesd.
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Map;
import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;
import javax.swing.*;
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
    private static DecimalFormat df = new DecimalFormat("###.##");
    private static Login Lenter = new Login();


    public static void login() throws Exception { // first screen 
        frame = createFrame();

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        
        userLabel = new JLabel("Username: ");
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
                
    public void actionPerformed(ActionEvent e) { // This button will check the username and password for the Dictionary or the HashTable.
        // From the file user.txt

        String user = userTextField.getText();
        String password = passwordField.getText();
        String[] input= {user,password};
        try { 
            LinkedHashMap<Integer, String[]> Table = obj.IHaveNoIdea();

            System.out.println(Lenter.Lenter(input[0],input[1]));
            String[] fff = Table.get(Lenter.Lenter(input[0],input[1]));
            int accountNum = Integer.parseInt(fff[0]);
            Double accountBalac = Double.parseDouble(fff[1]);
            obj.setAccountNumber(accountNum);
            obj.setBalance(accountBalac);
            secondGui();
            } catch (FileNotFoundException e1) {
            
            System.out.println("check for missing file (BankUsers.txt)");
            e1.printStackTrace();
        } catch (NullPointerException e2) {
            messageLabel.setText("Incorrect UserName");;
        }   
    }
        });
        panel.add(button);

        messageLabel = new JLabel("");
        messageLabel.setBounds(150, 90, 150, 25);
        panel.add(messageLabel);

        frame.setVisible(true);
    }
    private static void secondGui() throws FileNotFoundException {
        frame.setVisible(false); // Close the first screen after logging in
        JFrame frame1 = createFrame2();
        JPanel buttonPanel = new JPanel(); // Create button panel at the top of the second screen.
        JLayeredPane layeredPane = new JLayeredPane();
        JPanel homePanel = homPanel();
        JPanel withdrawPanel = withdrawPanel();
        JPanel depositPanel = depositPanel();


        buttonPanel.setBounds(0, 0, 632, 70);
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Services")); // Border
        JButton homeButton = new JButton("Home"); // Button 1
        homeButton.addActionListener(new GUI() { // switch between panel when prssed
            public void actionPerformed(ActionEvent e) {
                layeredPane.removeAll();
                layeredPane.add(homePanel);
                layeredPane.repaint();
                layeredPane.revalidate();
            }
        });
        buttonPanel.add(homeButton);
        JButton withdrawSwitchButton = new JButton("Withdraw"); // Button 2
        withdrawSwitchButton.addActionListener(new GUI() { // switch between panel when prssed
            public void actionPerformed(ActionEvent e) {
                layeredPane.removeAll();
                layeredPane.add(withdrawPanel);
                layeredPane.repaint();
                layeredPane.revalidate();
            }
        });
        buttonPanel.add(withdrawSwitchButton);
        JButton depositSwitchButton = new JButton("deposit"); //Butten 3
        buttonPanel.add(depositSwitchButton);
        depositSwitchButton.addActionListener(new GUI() {
            public void actionPerformed(ActionEvent e) { // switch between panel when prssed
                layeredPane.removeAll();
                layeredPane.add(depositPanel);
                layeredPane.repaint();
                layeredPane.revalidate();
            }
        });
        frame1.add(buttonPanel);
        
        layeredPane.setBounds(2,70,630,290); // place.
        layeredPane.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        layeredPane.setLayout(null);
        JLabel welcomeLabel = new JLabel("Welcome to our bank!");
        JLabel acountLabel = new JLabel("Your acount number is: " + obj.getAccountNumber()); // In home panel show the account number and
        JLabel balanceLabel = new JLabel("Your balance is: $" + obj.getBalance()); //balance amount.
        
        layeredPane.add(homePanel);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBounds(155, 5, 185, 25);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        
        // set a text for acount number (Integer To string) (Done)
        acountLabel.setBounds(100, 40, 300, 25);
        acountLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));

        // set a text for Balance (Double to String) (Done)
        balanceLabel.setBounds(100, 90, 300, 25);
        balanceLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));

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
        messagewithdrawLabel.setHorizontalAlignment(JLabel.CENTER);
        withdrawPanel.add(messagewithdrawLabel);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(50, 125, 130, 20);
        withdrawButton.addActionListener(new GUI() {
            public void actionPerformed(ActionEvent e) { // When the withdraw button is press this function will run.
                String successful = "Please take the amount ";
                String fails = "Invalid input";
                String notEnough = "You don't have that much to withdraw ";
                int maximumAmount = 5000;
                String tooMuch = "maximum amount to withdraw is $" + df.format(maximumAmount);
                String input = withdrawAmount.getText();
                if (isNumeric(input)) { // Checks the input value.
                    withdrawAmount.setText("");
                    // Add to balance function.
                    double wAmount = Double.parseDouble(input);
                    try {
                        if (obj.getBalance() > wAmount) {
                            if (maximumAmount >= wAmount) {
                                messagewithdrawLabel.setText(successful);
                                obj.setBalance(obj.withdraw(wAmount));
                                balanceLabel.setText("Your balance is: $" + df.format(obj.getBalance()));
                            } else {
                                messagewithdrawLabel.setText(tooMuch);
                            }        
                        } else {
                            messagewithdrawLabel.setText(notEnough);           
                        }
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                } else if (input.equals("")){
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
        messagedepositLabel.setHorizontalAlignment(JLabel.CENTER);
        depositPanel.add(messagedepositLabel);

        JButton depositButton = new JButton("deposit");
        depositButton.setBounds(50, 125, 130, 20);
        depositButton.addActionListener(new GUI() { // when the deposit button is press this function will run.
            public void actionPerformed(ActionEvent e) {
                String successful = "Money has been added to your balance";
                String fails = "Invalid input";
                int maximumAmount = 10000;
                String tooMuch = "maximum amount to deposit is $" + df.format(maximumAmount);
                String input = depositAmount.getText();
                if (isNumeric(input)) { // checks the input values.
                    depositAmount.setText("");
                    // Add to balance function.
                    double dAmount = Double.parseDouble(input);
                    try {
                        if (dAmount <= maximumAmount) {
                            messagedepositLabel.setText(successful);
                            obj.setBalance(obj.deposit(dAmount));
                            balanceLabel.setText("Your balance is: $" + df.format(obj.getBalance()));
                        } else {
                            messagedepositLabel.setText(tooMuch);
                        }
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
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
    private static JPanel depositPanel() { // Process depasit Panel
        JPanel depositPanel = new JPanel();
        depositPanel.setBounds(65, 45, 500, 200);
        depositPanel.setLayout(null);
        depositPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        return depositPanel;
    }

    private static JPanel withdrawPanel() { // process withdraw panel
        JPanel withdrawPanel = new JPanel();
        withdrawPanel.setBounds(65, 45, 500, 200);
        withdrawPanel.setLayout(null);
        withdrawPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        return withdrawPanel;
    }

    private static JFrame createFrame2() { // bank frame (second frame)
        JFrame frame = new JFrame("Account");
        frame.setSize(new Dimension(650,400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        return frame;
    }
    private static JFrame createFrame() { // Login frame
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
        df.setGroupingUsed(true);
        df.setGroupingSize(3);
        login();  // Start the entire code via main function.
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
