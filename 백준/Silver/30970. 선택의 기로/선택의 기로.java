

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,((o1, o2) -> {
            if(o2[0]==o1[0]){
                return o1[1]-o2[1];
            }
            return o2[0]-o1[0];
        }));
        System.out.println(arr[0][0]+" "+arr[0][1]+" "+arr[1][0]+" "+arr[1][1]);
        Arrays.sort(arr,((o1, o2) -> {
            if(o2[1]==o1[1]){
                return o2[0]-o1[0];
            }
            return o1[1]-o2[1];
        }));
        System.out.println(arr[0][0]+" "+arr[0][1]+" "+arr[1][0]+" "+arr[1][1]);
    }
}
