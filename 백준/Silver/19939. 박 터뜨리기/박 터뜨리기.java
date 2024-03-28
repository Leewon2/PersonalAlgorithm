import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[K + 1];
        for (int i = 1; i < K; i++) {
            arr[i] = i;
        }
        int sum = (K-1)*(K)/2;
        int all = (K)*(K+1)/2;
        int last = N-sum;
        arr[K]=last;
        if(all>N){
            System.out.println(-1);
        }else{
            int idx= K-1;
            while(true){
                if(idx==0){
                    idx = K-1;
                }
                arr[idx]++;
                arr[K]--;
                if(arr[K]<=arr[K-1]) {
                    arr[K]++;
                    arr[idx]--;
                    break;
                }
                idx--;
            }
            System.out.println(arr[K]-arr[1]);
        }

    }
}
