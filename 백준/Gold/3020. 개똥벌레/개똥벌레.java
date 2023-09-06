

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
        int M = Integer.parseInt(st.nextToken());
        int[] dp = new int[M+2];
        for (int i = 0; i <N; i++) {
            int k = Integer.parseInt(br.readLine());
            // 아래서부터 커지는 수
            if (i % 2 == 0) {
                dp[1]+=1;
                dp[k+1]-=1;
            }else{
                dp[M-k+1]+=1;
                dp[M+1]-=1;
            }
        }
        int[] res = new int[M+2];
        int min = 99999999;
        for (int i = 1; i <= M; i++) {
            res[i] = res[i-1]+ dp[i];
            min = Math.min(min, res[i]);
        }
        int cnt=0;
        for (int i = 1; i <= M; i++) {
            if(res[i]==min) cnt++;
        }

        System.out.println(min+" "+cnt);
    }
}
