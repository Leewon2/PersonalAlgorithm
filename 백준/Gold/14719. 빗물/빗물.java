
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[W+2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] prefix = new int[W+2];
        int[] suffix = new int[W+2];
        for (int i = 1; i <= W; i++) {
            prefix[i] = Math.max(prefix[i-1],arr[i]);
        }
        for (int i = W; i >= 1; i--) {
            suffix[i]=Math.max(suffix[i+1],arr[i]);
        }
        int[] res = new int[W+2];
        for (int i = 1; i <= W; i++) {
            res[i] = Math.min(prefix[i],suffix[i]);
        }
        int cnt=0;
        for (int i = 1; i <= W; i++) {
            cnt+=res[i]-arr[i];
        }
        System.out.println(cnt);
    }
}
