import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int min = 0;
        for (int i = 0; i < n; i++) {
            arr[i] += i + 2;
            min = Math.max(min, arr[i]);
        }
        System.out.println(min);

    }
}
