

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] arr;
    static boolean[] visited;
    static long[] res;
    static long min;
    public static void main(String[] args) throws IOException {
        input();
        calculate();
        Arrays.sort(res);
        for (int i = 0; i < 3; i++) {
            System.out.print(res[i]+" ");
        }
    }

    private static void calculate(){
        for (int i = 0; i < N-2; i++) {
            int start = i+1;
            int end = N-1;
            while(start<end){
//                System.out.println("start : "+start+ " end : "+end);
                long k = arr[i]+arr[start]+arr[end];
                if(Math.abs(k)<min){
                    min = Math.abs(k);
                    res[0]=arr[i];
                    res[1] = arr[start];
                    res[2] = arr[end];
                }
                if(k<0){
                    start++;
                }else{
                    end--;
                }
            }

        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        min = Long.MAX_VALUE ;
        res = new long[3];

    }
}
