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

class Result {

    public static String superReducedString(String s) {
        String result = s;
        
        while(!result.equals(""))
        {
            boolean somethingDone = false;
            int n = result.length();
            for(int i = 0; i < n-1; i++)
            {
                if(result.charAt(i) == result.charAt(i+1))
                {
                    String first = "";
                    String second = "";
                    if(i > 0)
                    {
                        first = result.substring(0, i);
                    }
                    if(i < n-2)
                    {
                        second = result.substring(i+2, n);
                    }
                    result = first + second;
                    somethingDone = true;
                    break;
                }
            }
            // System.out.println(result);
            if(somethingDone)
            {
                continue;
            }
            else
            {
                break;
            }
            
        }
        if(result.equals(""))
        {
            return "Empty String";
        }
        
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
