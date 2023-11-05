

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)  throws IOException{
        input();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        int[] cnt = new int[N];
        int max=0;
        for (int i = 0; i < N; i++) {
            int res=0;
            if(arr[i].charAt(0)=='1') res++;
            for (int j = 1; j < L; j++) {
                if(arr[i].charAt(j)=='1' && arr[i].charAt(j-1)!='1'){
                    res++;
                }
            }
            cnt[i]=res;
            max = Math.max(max, res);
        }
        int count =0;
        for (int i = 0; i < N; i++) {
            if(cnt[i]==max) count ++;
        }
        System.out.println(max+" "+count);
    }
}
