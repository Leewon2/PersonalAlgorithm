import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] road = new long[N-1];
        long[] liter = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            road[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liter[i] = Long.parseLong(st.nextToken());
        }
        long min = liter[0];
        long sum=0;
        for (int i = 0; i < N - 1; i++) {
            min = Math.min(min,liter[i]);
            sum+=(min*road[i]);
        }
        System.out.println(sum);
    }


}


//
/*
 * 2143
 * 3412
 * */
