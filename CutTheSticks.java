import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CutTheSticks {

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {

        ArrayList<Integer> tempResult = new ArrayList<>();
        int[] result;
        int[] temp = arr.clone();
        tempResult.add(arr.length);
        while(temp.length > 1)
        {
            ArrayList<Integer> temp1 = new ArrayList<>();
            int m = 0;
            int min = minimum(temp);
            for(int j = 0; j < temp.length; j++)
            {
                temp[j] = temp[j] - min;
                //System.out.println("temp : " + temp[j]);
                if(temp[j] > 0)
                {
                    temp1.add(temp[j]);
                    m++;
                    //System.out.println("Temp 1: " + temp1.get(m-1));
                }
            }

            //System.out.println(m);
            if(m > 0)
            {
                tempResult.add(m);
            }

            temp = temp1.stream().mapToInt(c -> c).toArray();
        }
        result = tempResult.stream().mapToInt(c -> c).toArray();
        
        return result;

    }

    static int minimum(int[] arr)
    {
        int min = arr[0];
        for(int i = 1; i < arr.length; i++)
        {
            if(min > arr[i])
            {
                min = arr[i];
            }
        }

        return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
