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
    
    public static void merge(List<String> arr, int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
 
        List<String> L = new ArrayList<>(n1);
        List<String> R = new ArrayList<>(n2);
 
        for (int i = 0; i < n1; ++i)
            L.add(i, arr.get(l + i));
        for (int j = 0; j < n2; ++j)
            R.add(j, arr.get(m + 1 + j));
 
        int i = 0, j = 0;
 
        int k = l;
        while (i < n1 && j < n2) {
            if (lessThanOrEqual(L.get(i), R.get(j))) {
                arr.set(k, L.get(i));
                i++;
            }
            else {
                arr.set(k, R.get(j));
                j++;
            }
            k++;
        }
 
        while (i < n1) {
            arr.set(k, L.get(i));
            i++;
            k++;
        }
 
        while (j < n2) {
            arr.set(k, R.get(j));
            j++;
            k++;
        }
    }
    
    public static void mergeSort(List<String> arr, int l, int r)
    {
        if (l < r) 
        {
            int m =l+ (r-l)/2;
 
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
 
            merge(arr, l, m, r);
        }
    }
    
    public static boolean lessThanOrEqual(String s1, String s2)
    {
        int i = 0;
        int j = 0;
        int n1 = s1.length();
        int n2 = s2.length();
        
        if(s1.length() < s2.length())
        {
            return true;
        }
        else if(s1.length() > s2.length())
        {
            return false;
        }
        else
        {
            if(s1.equals(s2))
            {
                return true;
            }
            while(i < n1 && j < n2)
            {
                if(s1.charAt(i) < s2.charAt(j))
                {
                    return true;
                }
                if(s1.charAt(i) > s2.charAt(j))
                {
                    return false;
                }
                i++;
                j++;
            }
        }
        return true;
    }

    public static List<String> bigSorting(List<String> unsorted) {
        int n = unsorted.size();
        mergeSort(unsorted, 0, n-1);
        return unsorted;
    }

}

public class BigSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> unsorted = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.bigSorting(unsorted);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
