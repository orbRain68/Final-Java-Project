import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Login {
    private static String track = "";

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
    public String rInHistory(Double amount,String stat) {
        GregorianCalendar gCalendar = new GregorianCalendar();
        String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", 
         "Oct", "Nov", "Dec"};
        String date = months[gCalendar.get(Calendar.MONTH)]+" "+gCalendar.get(Calendar.DATE)+" "+gCalendar.get(Calendar.YEAR)+
        " "+gCalendar.get(Calendar.HOUR)+":"+gCalendar.get(Calendar.MINUTE)+":"+gCalendar.get(Calendar.SECOND);

        if (stat.equals("Deposit")) {
            track = track.concat(String.format("You %s on %s \t\t  | (+%.2f)\n", stat,date,amount));
        } else {
            track = track.concat(String.format("You %s on %s \t\t  | (-%.2f)\n", stat,date,amount));
        }
        return track;
    }
}