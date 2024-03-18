import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] vip = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            vip[Integer.parseInt(br.readLine())] = true;
        }
        int[] dp = new int[41];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <= 40; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        Queue<Integer> q = new LinkedList<>();
        int cnt=0;
        for (int i = 1; i <= N; i++) {
            if(vip[i]) {
                if(cnt!=0){
                    q.offer(dp[cnt]);
                }
                cnt=0;
            }else{
                cnt++;
            }
        }
        if(cnt!=0){
            q.offer(dp[cnt]);
        }
        long sum=1;
        while (!q.isEmpty()) {
            sum *= q.poll();
        }
        System.out.println(sum);
    }
}
