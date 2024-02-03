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
        System.out.println(calculate(N, K));


    }

    private static int calculate(int N, int K) {
        int cnt=0;
        for (int i = 1; i <= N; i++) {
            if(N%i==0) cnt++;
            if(cnt==K) return i;
        }
        return 0;
    }


}


//
/*
 * 2143
 * 3412
 * */
