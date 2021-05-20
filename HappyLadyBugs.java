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

    public static String happyLadybugs(String b) {
        
        String result = "NO";
        int n = b.length();
        int count = 0;
        boolean sequenceMissing = false;
        HashMap<Character, Integer> myTable = new HashMap();
        for(int i = 0; i < n; i++)
        {
            if(b.charAt(i) != '_')
            {
                if(myTable.containsKey(b.charAt(i)))
                {
                    myTable.replace(b.charAt(i), myTable.get(b.charAt(i)) + 1);
                    count++;
                }
                else
                {
                    myTable.put(b.charAt(i), 1);
                    count++;
                }
            }    
            // if((i < n-1) && !sequenceMissing && (b.charAt(i) != b.charAt(i + 1)))
            // {
            //     sequenceMissing = true;
            // }
            
            if((i > 1) && !sequenceMissing)
            {
                if((b.charAt(i-1) == b.charAt(i-2)) || (b.charAt(i-1) == b.charAt(i)))
                {
                            
                }
                else
                {
                    sequenceMissing = true;
                }
            }
            if(i > 1 && i == n-1 && !sequenceMissing && (b.charAt(i) != b.charAt(i-1)))
            {
                sequenceMissing = true;
            }
        }
        
        // for(Character key : myTable.keySet())
        // {
        //     System.out.print(myTable.get(key) + " ");
        // }
        
        if(count == 0)
        {
            return "YES";
        }
        if(!sequenceMissing && count > 1 && n >= 3)
        {
            return "YES";
        }
        boolean hasTwo = false;
        for(Character key : myTable.keySet())
        {
            if(myTable.get(key) <= 1)
            {
                return "NO";
            }    
            else
            {
                hasTwo = true;
            }        
        }
        
        if(hasTwo && (count < n))
        {
            return "YES";
        }        
        // System.out.println();
        return result;

    }

}

public class HappyLadyBugs {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String b = bufferedReader.readLine();

                String result = Result.happyLadybugs(b);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
