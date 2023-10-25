
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static String N;
    static int[] dp;
    static boolean[] check;
    static int len;


    static int res;

    public static void main(String[] args) throws IOException {
        input();
        calculateDp();
        System.out.println(finalCalculate());
//        System.out.println(finalCal(560));
//        System.out.println(Arrays.toString(dp));
    }

    private static int finalCalculate(){
        if(dp[Integer.parseInt(N)]==0){
            return -1;
        }else{
            return finalCal(Integer.parseInt(N));
        }
    }
    private static int finalCal(int idx) {
        int res=Integer.MAX_VALUE;
        String id = String.valueOf(idx);
        for (int r = 0; r <id.length() ; r++) {
            String num = "";
            // 0 이면 추가 안함
            if(id.charAt(r)=='0') continue;
            num += id.charAt(r);

            int realNum = Integer.parseInt(id);
            int n = Integer.parseInt(num);
            int temp = realNum - n;
            if(dp[temp]==0){
                res = Math.min(res, n);
            }


            // 메서드
            for (int c = r + 1; c < id.length(); c++) {
                if (r == 0 && c == id.length() - 1)
                    break;
                num += id.charAt(c);
                n = Integer.parseInt(num);
                temp = realNum - n;
                if(dp[temp]==0){
                    res = Math.min(res, n);
                }
                // 메서드


            }

        }
        return res;
    }

    // people 1 은 A 0 은 B
    private static void calculate(int idx) {
        String id = String.valueOf(idx);
        outer : for (int r = 0; r <id.length() ; r++) {
            String num = "";
            // 0 이면 추가 안함
            if(id.charAt(r)=='0') continue;
            num += id.charAt(r);
            int realNum = Integer.parseInt(id);
            int n = Integer.parseInt(num);
            int temp = realNum - n;
            if(dp[temp]==0){
                dp[idx]=-1;
                break;
            }
            // 메서드
            for (int c = r + 1; c < id.length(); c++) {
                if (r == 0 && c == id.length() - 1)
                    break;
                num += id.charAt(c);

                n = Integer.parseInt(num);
                temp = realNum - n;
                if(dp[temp]==0){
                    dp[idx]=-1;
                    break outer;
                }
                // 메서드
            }

        }
    }
    private static void calculateDp(){
        for (int i = 11; i <= Integer.parseInt(N); i++) {
            calculate(i);
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        dp = new int[Integer.parseInt(N)+1];
        len = N.length();
        res = Integer.MAX_VALUE;
        check = new boolean[N.length()];

        for(int i=1; i<=Integer.parseInt(N); i++){
            if(i==10){
                dp[i]=-1;
                break;
            }
            dp[i] = 0;

        }


        // -1이면 내가 이긴 판
        // 백트랙킹 돌려서 dp[x]가 -1 이면 상대가 이김
        // 0이 하나라도 있다면 dp[-1]으로 표기

    }
}
