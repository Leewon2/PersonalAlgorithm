

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;
    static boolean[][] visitBlack;
    static boolean[][] visitWhite;
    static int blackCnt;
    static int whiteCnt;
    static int[] dr = {1, 1, -1, -1};
    static int[] dc = {1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        input();

        changeVisit(visitBlack, 0, 0, 0, 0);
        changeVisit(visitWhite, 0, 1, 0, 1);
//        System.out.println(blackCnt);
//        System.out.println(whiteCnt);
        System.out.println(blackCnt + whiteCnt);
    }

    private static boolean check(boolean[][] visit, int x, int y) {

        if (arr[x][y] == 0) return false;
        for (int i = 0; i < 4; i++) {
            int nr = x;
            int nc = y;
            while (true) {
                nr += dr[i];
                nc += dc[i];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) break;
                if (visit[nr][nc]) return false;
            }
        }
        return true;
    }

    private static void changeVisit(boolean[][] visit, int x, int y, int cnt, int color) {
//        if(color==0){
//        for(boolean[] list : visit){
//            System.out.println(Arrays.toString(list));
//        }
//        System.out.println("################################");}

        if (color == 0) blackCnt = Math.max(blackCnt, cnt);
        else whiteCnt = Math.max(whiteCnt, cnt);
        if (y >= N) {
            x += 1;
            if (color == 0) y = (x % 2 == 0) ? 0 : 1;
            else y = (x % 2 == 0) ? 1 : 0;
        }
        if (x >= N) return;
        if (check(visit, x, y)) {
            visit[x][y] = true;
            changeVisit(visit, x, y + 2, cnt + 1, color);
            visit[x][y] = false;
        }
        changeVisit(visit, x, y + 2, cnt, color);

    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visitBlack = new boolean[N][N];
        visitWhite = new boolean[N][N];
        blackCnt = 0;
        whiteCnt = 0;
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
