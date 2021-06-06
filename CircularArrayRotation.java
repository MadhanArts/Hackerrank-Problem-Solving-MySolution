import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CircularArrayRotation {

    // Complete the circularArrayRotation function below.
    static int[] circularArrayRotation(int[] a, int k, int[] queries) {

        int[] result = new int[queries.length];
        int temp[] = new int[a.length];
        int n = a.length;

        // for(int i = 1; i<= k; i++)
        // {
        //     temp[0] = a[n-1];
        //     for(int j = 1; j < a.length; j++)
        //     {
        //         temp[j] = a[j-1];
        //     }
        //     a = temp.clone();
        // }
        // for(int i = 0; i<queries.length; i++)
        // {
        //     result[i] = a[queries[i]];
        // }

        int j = 0;

        k = k%a.length;

        for(int i = a.length-k; i < a.length; i++)
        {
            temp[j++] = a[i];
        }

        for(int i = 0; i < a.length-k; i++)
        {
            temp[j++] = a[i];
        }

        // for(int i = 0; i < temp.length; i++)
        // {
        //     System.out.println(temp[i]);
        // }

        for(int i = 0; i<queries.length; i++)
        {
            result[i] = temp[queries[i]];
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nkq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nkq[0]);

        int k = Integer.parseInt(nkq[1]);

        int q = Integer.parseInt(nkq[2]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] queries = new int[q];

        for (int i = 0; i < q; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        int[] result = circularArrayRotation(a, k, queries);

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
