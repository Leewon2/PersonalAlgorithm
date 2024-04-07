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
                // 끝이 아닌 경우 다음 것, 이전 것과 비교해서 서로 길이가 다르다면,
                // 1. 앞 뒤로, 1만큼 차이나는지 확인한다. 1만큼 차이가 안날경우 break 한다.
                // 2. 1만큼 차이날 경우(1만큼 작을경우), L길이까지 확인한다.
                // 이때, N범위를 넘어가거나, 중간에 높이가 다른애가 생기면 끝

                // 이전 것과 비교해서 차이가 나는지 비교
                // 현재와 이전이 다르다면?
                if (j > 0 && arr[i][j] > arr[i][j - 1]) {
                    // 1보다 크면 확인할 필요가 없음, 현재 위치 - L 만큼 존재하지 않으면, 범위를 벗어나는 것.
                    if (arr[i][j] - arr[i][j - 1] != 1 || j - L < 0 || rowVisited[i][j - 1]) {
                        check = false;
                        break;
                    }
                    int before = arr[i][j - 1];
                    for (int k = 2; k <= L; k++) {
                        if (arr[i][j - k] != before || rowVisited[i][j - k]) {
                            check = false;
                            break outer;
                        }
                    }
                    // 사용한 녀석들은 true로 변경
                    for (int k = 1; k <= L; k++) {
                        rowVisited[i][j - k] = true;
                    }
                }
                // 내 앞이 나보다 작은 경우도 확인
                if (j < N - 1 && arr[i][j] > arr[i][j + 1]) {
                    if (arr[i][j] - arr[i][j + 1] != 1 || j + L >= N || rowVisited[i][j + 1]) {
                        check = false;
                        break;
                    }
                    int before = arr[i][j + 1];
                    for (int k = 2; k <= L; k++) {
                        if (arr[i][j + k] != before || rowVisited[i][j + k]) {
                            check = false;
                            break outer;
                        }
                    }
                    // 사용한 녀석들은 true로 변경
                    for (int k = 1; k <= L; k++) {
                        rowVisited[i][j + k] = true;
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
                    for (int k = 2; k <= L; k++) {
                        if (arr[j - k][i] != before || colVisited[j - k][i]) {
                            check = false;
                            break outer;
                        }
                    }
                    // 사용한 녀석들은 true로 변경
                    for (int k = 1; k <= L; k++) {
                        colVisited[j - k][i] = true;
                    }
                }

                if (j < N - 1 && arr[j][i] > arr[j + 1][i]) {
                    if (arr[j][i] - arr[j + 1][i] != 1 || j + L >= N || colVisited[j + 1][i]) {
                        check = false;
                        break;
                    }
                    int before = arr[j + 1][i];
                    for (int k = 2; k <= L; k++) {
                        if (arr[j + k][i] != before || colVisited[j + k][i]) {
                            check = false;
                            break outer;
                        }
                    }

                    for (int k = 1; k <= L; k++) {
                        colVisited[j + k][i] = true;
                    }
                }
            }
            if (check) cnt++;
        }
        System.out.println(cnt);
    }


}
