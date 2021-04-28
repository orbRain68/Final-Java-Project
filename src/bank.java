/*
 * CS-112 L02
 * Java Project 2.
 * 28/04/2021
 */
import java.util.Hashtable;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Dictionary;

/**
 * @author [Abdulrazaq 4020018]
 */
public class bank {
    private String name; // Use the name to get acount number and balance from file called bankUsers.txt and set username and password()
    private String acountNumber ;
    private double[] balance;
    private String [][]username = {{"razaq","CarLover202"},{"miky","catdude9"},{"A","A"}}; //store in an array.
    //private String []Password; // store in an array
    private Hashtable<String, String[]> my_dict;

    
    public Hashtable<String,String[]> IHaveNoIdea() throws FileNotFoundException {
        File file = new File("src/BankUsers.txt");
        Scanner userScanner = new Scanner(file);
        String[][] value = this.username;
        my_dict = new Hashtable<String, String[]>();
        int i = 0;
        while (userScanner.hasNextLine()) {
            String reader = userScanner.nextLine();
            int indxNum = reader.indexOf("number");
            int indx = reader.indexOf(".",indxNum);
            String key = reader.substring(indxNum+8,indx);
            String[] values = value[i];
            
            my_dict.put(key, values);
            i++;
        }
        userScanner.close();
        return my_dict;
    }
    public void balance() {
        
    }
    /*
    private boolean checkUsernameAndPassword(String userName,String password) {
        return true;
    }
    */
    public String getAccountNumber() { //Getter
        return this.acountNumber;
    }
    
    public void setAccountNumber(String accounts) { //Setter
        // get the information from the file ()
        this.acountNumber = accounts;
    }

}
