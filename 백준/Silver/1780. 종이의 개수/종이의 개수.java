

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] countArr;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        countArr = new int[3];
        divide(0,0,N);
        System.out.println(countArr[0]);
        System.out.println(countArr[1]);
        System.out.println(countArr[2]);

    }

    private static boolean checkSameNumber(int r, int c, int n) {
        int k = arr[r][c];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[r + i][c + j] != k) return false;
            }
        }
        return true;
    }

    private static void divide(int r, int c, int n) {
        if (checkSameNumber(r, c, n)) {
            countArr[arr[r][c] + 1]++;
        } else {
            int idx = n / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    divide(r + idx * i, c + idx * j, idx);
                }
            }
        }
    }
}
