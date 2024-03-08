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
        String str = br.readLine();
        boolean[] use = new boolean[N];
        int cnt=0;
        for (int i = 0; i < str.length(); i++) {
            int min = Math.max(0, i - K);
            int max = Math.min(N - 1, i + K);
            if (str.charAt(i) == 'P') {
                for (int j = min; j <= max; j++) {
                    if(str.charAt(j)=='H' && !use[j]){
                        use[j]=true;
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
