import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[][] rowVisited = new boolean[N][N];
        boolean[][] colVisited = new boolean[N][N];
        int cnt = 0;
        boolean check = true;
        for (int i = 0; i < N; i++) {
            check = true;
            outer:
            for (int j = 0; j < N; j++) {
                if (j > 0 && arr[i][j] > arr[i][j - 1]) {
                    if (arr[i][j] - arr[i][j - 1] != 1 || j - L < 0 || rowVisited[i][j - 1]) {
                        check = false;
                        break;
                    }
                    int before = arr[i][j - 1];
                    for (int k = 1; k <= L; k++) {
                        if (arr[i][j - k] != before || rowVisited[i][j - k]) {
                            check = false;
                            break outer;
                        }
                        rowVisited[i][j-k] = true;
                    }
                }
                if (j < N - 1 && arr[i][j] > arr[i][j + 1]) {
                    if (arr[i][j] - arr[i][j + 1] != 1 || j + L >= N || rowVisited[i][j + 1]) {
                        check = false;
                        break;
                    }
                    int before = arr[i][j + 1];
                    for (int k = 1; k <= L; k++) {
                        if (arr[i][j + k] != before || rowVisited[i][j + k]) {
                            check = false;
                            break outer;
                        }
                        rowVisited[i][j+k] = true;
                    }
                }
            }
            if (check) cnt++;
        }
        for (int i = 0; i < N; i++) {
            check = true;
            outer:
            for (int j = 0; j < N; j++) {
                if (j > 0 && arr[j][i] > arr[j - 1][i]) {
                    if (arr[j][i] - arr[j - 1][i] != 1 || j - L < 0 || colVisited[j - 1][i]) {
                        check = false;
                        break;
                    }
                    int before = arr[j - 1][i];
                    for (int k = 1; k <= L; k++) {
                        if (arr[j - k][i] != before || colVisited[j - k][i]) {
                            check = false;
                            break outer;
                        }
                        colVisited[j - k][i] = true;
                    }
                }
                if (j < N - 1 && arr[j][i] > arr[j + 1][i]) {
                    if (arr[j][i] - arr[j + 1][i] != 1 || j + L >= N || colVisited[j + 1][i]) {
                        check = false;
                        break;
                    }
                    int before = arr[j + 1][i];
                    for (int k = 1; k <= L; k++) {
                        if (arr[j + k][i] != before || colVisited[j + k][i]) {
                            check = false;
                            break outer;
                        }
                        colVisited[j+k][i] = true;
                    }
                }
            }
            if (check) cnt++;
        }
        System.out.println(cnt);
    }
}
