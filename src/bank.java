/*
 * CS-112 L02
 * Java Project 2.
 * 28/04/2021
 */
// Packages uesd.
import java.util.Hashtable;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * @author [Abdulrazaq 4020018]
 */
public class bank {
    private String acountNumber ; // Use the accountnumber form the text file (BankUsers.txt) and set username and password.
    private double balance;
    private String [][]usernamePassword = {{"Hamood","CarLover202"},{"miky","catdude9"},{"A","A"}}; //store in an array.
    private Hashtable<String, String[]> my_dict; // Dictionary

    public Hashtable<String,String[]> IHaveNoIdea() throws FileNotFoundException {
        File file = new File("C:/Users/me/Desktop/New JAVA/Final_Project/src/bankUsers.txt");
        Scanner userScanner = new Scanner(file);
        String[][] value = this.usernamePassword;
        my_dict = new Hashtable<String, String[]>();
        int i = 0;
        while (userScanner.hasNextLine()) {
            String reader = userScanner.nextLine();
            int indxNum = reader.indexOf("number");
            int indx = reader.indexOf(".",indxNum);
            String key = reader.substring(indxNum+8,indx);
            String[] values = value[i]; // Storing each Username and password in an array
            
            my_dict.put(key, values); // With this line I can call the account number and get the username and password.
            i++;
        }
        userScanner.close();
        return my_dict;
    }
    public double[] balance() throws FileNotFoundException { // call each balance amount form each user and add it to an array.
        File sourceFile = new File("C:/Users/me/Desktop/New JAVA/Final_Project/src/BankUsers.txt");
        Scanner scan = new Scanner(sourceFile);
        double[] balance = new double[3];
        int i = 0;
        while (scan.hasNextLine()) {
            String reader = scan.nextLine();
            int indxNum = reader.lastIndexOf("$");
            double Money = Double.parseDouble(reader.substring(indxNum+1));
            balance[i] = Money;
            //System.out.println(Money);
            i++;
        }
        scan.close();
        return balance;
    }
    public double deposit(double amount) { // deposit the entered amount.
        return this.balance = this.balance + amount;
    }
    public double withdraw(double amount) { // Withdraw the entered amount.
            return this.balance = this.balance - amount;
    }
    public String getAccountNumber() { //Getter for account number
        return this.acountNumber;
    }
    
    public void setAccountNumber(String accounts) { //Setter for account number
        // get the information from the file ()
        this.acountNumber = accounts;
    }
    public void setBalance(double b) { // Setter for diffrent values. 
        this.balance = b;
    }
    public double getBalance() throws FileNotFoundException { // Getter for current values.
        return this.balance;
    }
}
