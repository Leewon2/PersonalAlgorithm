

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        input();
    }

    private static int[] twoPointer(int s, int e, int[] res){
        int sum= Integer.MAX_VALUE;
        while (s != e) {
            // 0보다 큰 경우
            if(arr[s]+arr[e]>0){
                if(Math.abs(arr[s]+arr[e])<sum){
                    sum=Math.abs(arr[s]+arr[e]);
                    res[0]=arr[s];
                    res[1]=arr[e];
                }
                e--;
            }
            // 0보다 작은 경우
            else if(arr[s]+arr[e]<0){
                if(Math.abs(arr[s]+arr[e])<sum){
                    sum=Math.abs(arr[s]+arr[e]);
                    res[0]=arr[s];
                    res[1]=arr[e];
                }
                s++;
            }
            // 0인 경우
            else{
                res[0]=arr[s];
                res[1]=arr[e];
                break;
            }
        }

        return res;
    }

    private static void result(int[] res){
        System.out.println(res[0]+" "+res[1]);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int s=0;
        int e=N-1;
        int[] res = new int[2];

        result(twoPointer(s,e,res));
    }
}
