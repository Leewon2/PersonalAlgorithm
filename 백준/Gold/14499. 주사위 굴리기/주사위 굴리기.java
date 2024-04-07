import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {0, 0, 0, -1, 1};
    static int[] dc = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dice = new int[7];

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] order = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }
        int nr = x;
        int nc = y;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            int dir = order[i];
            nr = x + dr[dir];
            nc = y + dc[dir];
            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            x = nr;
            y = nc;
            int temp = dice[3];
            switch (dir) {
                // 동
                case 1:
                    dice[3] = dice[2];
                    dice[2] = dice[6];
                    dice[6] = dice[4];
                    dice[4] = temp;
                    break;
                // 서
                case 2:
                    dice[3] = dice[4];
                    dice[4] = dice[6];
                    dice[6] = dice[2];
                    dice[2] = temp;
                    break;
                // 남
                case 3:
                    dice[3] = dice[1];
                    dice[1] = dice[6];
                    dice[6] = dice[5];
                    dice[5] = temp;
                    break;
                // 북
                case 4:
                    dice[3] = dice[5];
                    dice[5] = dice[6];
                    dice[6] = dice[1];
                    dice[1] = temp;
                    break;
            }
            if(arr[x][y]==0){
                arr[x][y] = dice[6];
            }else{
                dice[6] = arr[x][y];
                arr[x][y] = 0;
            }
            sb.append(dice[3]).append("\n");

        }
        System.out.println(sb);
    }

}
