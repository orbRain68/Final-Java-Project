import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Login {
    public int Lenter(String userString,String passString) throws FileNotFoundException{
        File file = new File("C:/Users/me/Desktop/New JAVA/Final_Project/src/use_this_to_gain_access.txt");
        Scanner insideFile = new Scanner(file);
        //String userString,passString;
        int i = 1;
        int  matchNum = 0;
        while (insideFile.hasNextLine()) {
            if (insideFile.nextLine().equals(i+":")) {
                if (insideFile.nextLine().equals(userString) && insideFile.nextLine().equals(passString)) {
                matchNum += i;
                }
                i++;
            }
        }
        insideFile.close();
        return matchNum;
    }
}