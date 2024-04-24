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
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            res[i][0] = arr[i][0];
            res[i][1] = idx;

            int j = i + 1;
            int k = 1;
            while (j < N) {
                if (arr[i][1] == arr[j][1] && arr[i][2] == arr[j][2] && arr[i][3] == arr[j][3]) {
                    res[j][0] = arr[j][0];
                    res[j][1] = idx;
                    visited[j] = true;
                    k++;
                    j++;
                } else {
                    break;
                }
            }
            idx += k;

        }
        for (int i = 0; i < N; i++) {
//            System.out.println("번호 : " + res[i][0] + " " + "등수 : " + res[i][1]);
            if (res[i][0] == K) {
                System.out.println(res[i][1]);
                break;
            }
        }
    }
}
