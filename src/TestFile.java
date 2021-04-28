/**
 * TestFile
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;

public class TestFile {
    public static void main(String[] args) throws IOException{
        File sourceFile = new File("src/BankUsers.txt");
        Scanner scan = new Scanner(sourceFile);


        while (scan.hasNextLine()) {
            String reader = scan.nextLine();
            int indxNum = reader.indexOf("number");
            int indx = reader.indexOf(".",indxNum);
            String cut = reader.substring(indxNum+8,indx);
            System.out.println(cut);

            
        }
        //int indx = scan.next().indexOf("-");
        //System.out.println(indx);
        //System.out.println(scan.rea()).substring(1,4));
        //System.out.println(indx);
        //System.out.println(scan.nextLine().substring(1,4));
        //System.out.println(indx);
     
        
    
        scan.close();
    }
    
    
}