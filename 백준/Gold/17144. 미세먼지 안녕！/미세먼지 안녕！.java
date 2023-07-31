

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    static int R;
    static int C;
    static int T;
    static int[][] arr;
    static int[][] tempArr;
    static int[] cleaner;

    // 현재 drdc는 위 공기청정기 기준 => 그냥 +1
    // 아래 공기청정기는 0,3,2,1 순으로 가면 됨 => (현재+4-1)%4 하면됨
    static final int[] dr = {0, -1, 0, 1};
    static final int[] dc = {1, 0, -1, 0};
    static int result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        cleaner = new int[2];

        arr = new int[R][C];
        result = 0;


        int idx = 0;
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
                if (arr[r][c] == -1) cleaner[idx++] = r;
            }
        }

        for (int tc = 0; tc < T; tc++) {
            diffusion();

            combineArr();


            windUp();
            windDown();
        }
        calculate();
        System.out.println(result + 2);
//        for (int[] list : arr) {
//            System.out.println(Arrays.toString(list));
//        }


    }

    static void calculate() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                result += arr[r][c];
            }
        }
    }

    // 미세먼지 확산
    // 인접한 4칸확산
    // 공기청정기 or 범위밖은 안감
    // Arc/5만큼 확산
    // 남은 미세먼지는 확산된 Arc - Arc/5 * 확산된 방향 수
    static void diffusion() {
        tempArr = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int k = arr[r][c] / 5;
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (nr < 0 || nc < 0 || nr >= R || nc >= C || arr[nr][nc] == -1) continue;

                    tempArr[nr][nc] += k;
                    arr[r][c] -= k;
                }
            }
        }
    }

    static void combineArr() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                arr[r][c] += tempArr[r][c];
            }
        }
    }

    // 공기청정기 바람 위 아래에서 나옴
    // 한 칸씩 이동
    // 공기청정기로 들어가면 모두 정화
    static void windUp() {
//        tempArr = new int[R][C];
        int r = cleaner[0];
        int c = 0;
        int nr = r;
        int nc = c + 1;
        int idx = 0;
        int temp = arr[nr][nc];
        arr[nr][nc]=0;
        while (true) {
            nr += dr[idx];
            nc += dc[idx];
//            System.out.println("nr : " + nr + " nc : " + nc);
            // 종료조건

            // 범위 벗어나는 경우
            if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                // 제자리로 돌리기
                nr -= dr[idx];
                nc -= dc[idx];
                // 방향 전환
                idx++;
            } else {
                if (arr[nr][nc] == -1) break;
                int x = arr[nr][nc];
                arr[nr][nc] = temp;
                temp = x;

            }
        }

//        for (int rr = 0; rr < R; rr++) {
//            for (int cc = 0; cc < C; cc++) {
//                System.out.println("tempArr : " +tempArr[rr][cc]);
//                arr[rr][cc] = tempArr[rr][cc];
////                System.out.println(arr[rr][cc]);
//            }
//        }
        arr[cleaner[0]][0] = -1;
    }

    static void windDown() {
        tempArr = new int[R][C];
        int r = cleaner[1];
        int c = 0;
        int nr = r;
        int nc = c + 1;
        int idx = 0;
        int temp = arr[nr][nc];
        arr[nr][nc]=0;
        while (true) {
            r = nr;
            c = nc;
            nr += dr[idx];
            nc += dc[idx];
            // 종료조건

            // 범위 벗어나는 경우
            if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                // 제자리로 돌리기
                nr -= dr[idx];
                nc -= dc[idx];
                // 방향 전환
                idx = (idx + 3) % 4;
            } else {
                if (arr[nr][nc] == -1) break;
                int x = arr[nr][nc];
                arr[nr][nc] = temp;
                temp = x;
            }
        }

        arr[cleaner[1]][0] = -1;
    }



}
