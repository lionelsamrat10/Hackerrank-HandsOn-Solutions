import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    //Author: Samrat Mitra
    static String timeConversion(String s) {
        String hours = s.substring(0,2);
        String minutes = s.substring(3, 5);
        String seconds = s.substring(6, 8);
        String amOrPm = s.substring(8);
        if(amOrPm.equals("AM")){
            if(hours.equals("12")){
                hours = "00";
            }
        }else{
            if(!hours.equals("12")){
                int hour_int = Integer.parseInt(hours) + 12;
                hours = "" + hour_int;
            }
        }
        return (hours + ":" + minutes + ":" + seconds);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
