

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[][] arr;

    public static void main(String[] args) throws IOException {
        input();
        System.out.printf("%.1f", (double) Math.abs(shoestring(0, 1)-shoestring(1, 0))/2);

    }

    private static long shoestring(int x,int y) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum=sum + (arr[i][x] *arr[i+1][y]);
        }
        return sum;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N+1][2];
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[r][0] = Long.parseLong(st.nextToken());
            arr[r][1] = Long.parseLong(st.nextToken());

        }
        arr[N][0] = arr[0][0];
        arr[N][1] =arr[0][1];
    }
}
