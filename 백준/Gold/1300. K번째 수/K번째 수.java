

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        long left = 1;
        long right = K;
        long mid = (left+right)/2 ;
        while (left <= right) {
//            System.out.println(left + "mid : " + mid);

            long sum = 0;
            for (long i = 1; i <= N; i++) {
                // mid보다 작거나 같은 수를 찾아야 한다.
                sum += Math.min(N,mid/i);
            }
//            System.out.println(sum);
            if(sum<K){
                left = mid+1;
            }else {
                right = mid-1;
            }
            mid = (left + right) / 2;
        }
        System.out.println(mid+1);
    }
}
