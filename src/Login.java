import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Login {
    private static String[] allString = null;
    public String[] Lenter(int matchNum) throws FileNotFoundException{
        File file = new File("C:/Users/me/Desktop/New JAVA/Final_Project/src/use_this_to_gain_access.txt");
        Scanner insideFile = new Scanner(file);
        //String userString,passString;
        allString = new String[2];
        while (insideFile.hasNextLine()) {
            if (insideFile.nextLine().matches(matchNum+":")) {
                allString[0] = insideFile.nextLine();
                allString[1] = insideFile.nextLine();
                
            }
        }
        insideFile.close();
        return allString;
    }
}