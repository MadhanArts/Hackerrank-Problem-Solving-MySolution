import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DayOfTheProgrammer {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {

        String result = "";
        int days = 243;
        int date = 0;
        int month = 0;

        if(year >=1700 && year <=1917)
        {
            if(year%4 == 0)
            {
                date = 256-(days+1);
                month = 9;
            }
            else
            {
                date = 256-days;
                month = 9;
            }

        }
        else if(year == 1918)
        {
            date = 256-(days-13);
            month = 9;

        }
        else if(year >=1919 && year <=2700)
        {
            if((year%400 == 0) || (year%4==0 && year%100 != 0))
            {
                System.out.println("flag");
                date = 256-(days+1);
                month = 9;
            }
            else
            {
                date = 256-days;
                month = 9;
            }

        }

        result = String.format("%02d", date) + "." + String.format("%02d", month) + "." + year;

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
