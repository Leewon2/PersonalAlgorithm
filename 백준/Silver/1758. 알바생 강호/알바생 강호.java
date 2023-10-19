import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr,Collections.reverseOrder());
        long sum=0;
        for (int i = 0; i < N; i++) {
            long k = arr[i]-i;
            if(k<=0) continue;
            sum+=arr[i]-i;
        }
        System.out.println(sum);
    }
}