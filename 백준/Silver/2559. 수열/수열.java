import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start=0;
        for (int i = 0; i < K; i++) {
            start += arr[i];
        }
        int max = start;
        int compare = start;
        for (int i = 1; i < N - K +1; i++) {
            compare = compare - arr[i - 1] + arr[i + K -1];
            max = Math.max(compare, max);
        }
        System.out.println(max);
    }
}
