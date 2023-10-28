
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        boolean[] check = new boolean[1000001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int res=0;
        for (int i = 0; i < N; i++) {
            if(check[arr[i]]) continue;
            for (int j = arr[i]; j <= arr[i] + K; j++) {
                if(j>1000000) break;
                check[j] = true;
            }
            res++;
        }
        System.out.println(res);
    }
}
