import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
         String militarytime;
         int hr = Integer.parseInt(s.substring(0,2));
         String hrS;
         //System.out.println(hr);
         if(s.contains("PM") && hr<12)
         {
             hr = hr+12;
         }
         if(s.contains("AM") && hr == 12)
         {
             hr = 0;
         }
         if(hr<10)
         {
             hrS = "0" + hr;
         }
         else
         {
             hrS = Integer.toString(hr);
         }
         militarytime = hrS + s.substring(2,8);
         return militarytime;

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
