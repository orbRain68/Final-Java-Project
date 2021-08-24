/*
 * CS-112 L02
 * Java Project 2.
 * 28/04/2021
 */
// Packages uesd.
import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
/**
 * @author [Abdulrazaq 4020018]
 */
public class bank {
    private int acountNumber ; // Use the accountnumber form the text file (BankUsers.txt) and set username and password.
    private double balance;
    //private String [][]usernamePassword = {{"Hamood","CarLover202"},{"miky","catdude9"},{"A","A"}}; //store in an array.
    private LinkedHashMap<Integer, String[]> my_dict; // Dictionary

    public LinkedHashMap<Integer,String[]> IHaveNoIdea() throws FileNotFoundException {
        File file = new File("C:/Users/me/Desktop/New JAVA/Final_Project/src/bankUsers.txt");
        Scanner userScanner = new Scanner(file);
        my_dict = new LinkedHashMap<Integer, String[]>();
        int i = 0;
        while (userScanner.hasNextLine()) {
            int key;
            String[] value = new String [2];
            String reader = userScanner.nextLine();
            key = Integer.parseInt(String.valueOf(reader.charAt(0)));
            int indxNum = reader.indexOf(":",10);
            int indx = reader.indexOf(".",indxNum);
            value[0] = reader.substring(indxNum+2,indx);
            int bIndxNum = reader.lastIndexOf("$");
            value[1] = reader.substring(bIndxNum+1);
       
            my_dict.put(key, value); // With this line I can call the account number and get the username and password.
            i++;
        }
        userScanner.close();
        return my_dict;
    }
    public void saveAll(int position,String cash) {
        try {
            File fileRead = new File("C:/Users/me/Desktop/New JAVA/Final_Project/src/bankUsers.txt");
            String addIn = "";
            Scanner scan = new Scanner(fileRead);
            while (scan.hasNextLine()) {
                String reader = scan.nextLine();
                if (String.valueOf(reader.charAt(0)).equals(position+"")) {
                    int loc = reader.lastIndexOf("$");
                    reader = reader.substring(0,loc+1)+""+cash;
                }
                addIn = addIn.concat(reader+"\n");
            }
            scan.close();
            FileWriter myWriter = new FileWriter("C:/Users/me/Desktop/New JAVA/Final_Project/src/bankUsers.txt");
            myWriter.write(addIn);
            myWriter.close();

        } catch (IOException e) {
            //TODO: handle exception
        }
    }
    public double deposit(double amount) { // deposit the entered amount.
        return this.balance = this.balance + amount;
    }
    public double withdraw(double amount) { // Withdraw the entered amount.
            return this.balance = this.balance - amount;
    }
    public int getAccountNumber() { //Getter for account number
        return this.acountNumber;
    }
    
    public void setAccountNumber(int accounts) { //Setter for account number
        // get the information from the file ()
        this.acountNumber = accounts;
    }
    public void setBalance(double balance) { // Setter for diffrent values. 
        this.balance = balance;
    }
    public double getBalance() throws FileNotFoundException { // Getter for current values.
        return this.balance;
    }
}
