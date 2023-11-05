

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) return 1;
                else if (o1[0] == o2[0]) return 0;
                else return -1;
            }

        });
        boolean[] number = new boolean[1000001];
        int max = 0;
        int res=0;
        for (int i = 0; i < N; i++) {
            int k = arr[i][0];
            int sum = 0;
            if (!number[k]) {
                for (int j = i; j < N; j++) {
                    int x = k-arr[j][1];
                    if(x<0) continue;
                    sum+=x;
                }
                number[k]=true;
            }
            if(sum>max) {
                max=sum;
                res = k;
            }
        }
        System.out.println(res);
    }
}
