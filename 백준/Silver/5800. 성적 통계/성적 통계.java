import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append("Class ").append(i).append("\n");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int max=0;
            for(int j=0; j<n-1; j++){
                max = Math.max(max, arr[j + 1] - arr[j]);
            }
            sb.append("Max ").append(arr[n - 1]).append(", Min ").append(arr[0]).append(", Largest gap ").append(max).append("\n");

        }
        System.out.println(sb);

    }
}
