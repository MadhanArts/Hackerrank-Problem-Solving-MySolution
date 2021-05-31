import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ClimbingTheLeaderboard {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {

        int[] rankAlice = new int[alice.length];
        int[] rank = new int[scores.length];
        rank[0] = 1;
        for(int i = 1; i<scores.length; i++)
        {
            if(scores[i] == scores[i-1])
            {
                rank[i] = rank[i-1];
            }
            else if(scores[i] < scores[i-1])
            {
                rank[i] = rank[i-1] + 1;
            }
        }
        int s = scores.length;

        for(int i = 0; i<alice.length; i++)
        {
        
            if(alice[i] < scores[s-1])
            {
                rankAlice[i] = rank[s-1] + 1;
            }
            else if(alice[i] > scores[0])
            {
                rankAlice[i] = 1;
            }
            else
            {
                int index = binarySearch(scores, alice[i]);
                rankAlice[i] = rank[index];
            }
        }
        return rankAlice;
    }

    public static int binarySearch(int[] scores, int score)
    {
        int low = 0;
        int high = scores.length-1;

        while(low <= high)
        {
            int mid = (low + high)/2;
            if(scores[mid] == score)
            {
                return mid;
            }
            else if(scores[mid + 1] < score && score < scores[mid])
            {
                return mid+1;
            }
            else if(scores[mid - 1] > score && score > scores[mid])
            {
                return mid;
            }
            else if(scores[mid] < score)
            {
                high = mid-1;
            }
            else if(scores[mid] > score)
            {
                low = mid+1;
            }
        }
        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

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
