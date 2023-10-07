

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int X;

    static long[] arr;

    public static void main(String[] args) throws IOException {
        input();
        int idx=0;
        long sum=0;
        while(idx!=N){
            sum=0;
            for (int i = idx; i < N; i++) {
                idx++;
                sum+=arr[i];
                if(sum%X==0) {
                    sum=0;
                    break;
                }
            }
        }
        if(sum==0) System.out.println(1);
        else System.out.println(0);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new long[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {

            arr[i] = Long.parseLong(st.nextToken());
        }

    }
}
