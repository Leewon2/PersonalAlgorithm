import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][4];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] != o2[1]) return o2[1] - o1[1];
            else if (o1[2] != o2[2]) return o2[2] - o1[2];
            else if (o1[3] != o2[3]) return o2[3] - o1[3];
            return o1[0] - o2[0];
        });
        int[][] res = new int[N][2];
        int idx = 1;
        for (int i = 0; i < N; i++) {
            if (i < N - 1) {
                if (arr[i][1] == arr[i + 1][1] && arr[i][2] == arr[i + 1][2] && arr[i][2] == arr[i + 1][2]) {
                    res[i][0] = arr[i][0];
                    res[i][1] = idx;
                    res[i + 1][0] = arr[i + 1][0];
                    res[i + 1][1] = idx++;
                    i++;
                } else {
                    res[i][0] = arr[i][0];
                    res[i][1] = idx++;
                }
            } else {
                res[i][0] = arr[i][0];
                res[i][1] = idx++;
            }
        }
        for (int i = 0; i < N; i++) {
            if (res[i][0] == K) {
                System.out.println(res[i][1]);
                break;
            }
        }
    }
}
