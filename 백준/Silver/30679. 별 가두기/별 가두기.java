
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {0,1, 0, -1};
    static int[] dc = {1,0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        List<Integer> res = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            boolean[][][] dir = new boolean[N][M][4];
            int r = i;
            int c = 0;
            dir[r][c][3] = true;
            int idx=0;
            while (true) {
//                if(r<0 || c<0 || r>=N || c>=M) break;
                int nr =r+dr[idx%4]*arr[r][c];
                int nc= c+ dc[idx%4]*arr[r][c];
//                System.out.println("nr : "+nr+" nc : "+nc + " idx : "+idx);
                if(nr<0 || nc<0 || nr>=N || nc>=M) break;
                if(dir[nr][nc][idx%4]){
                    cnt++;
                    res.add(i+1);
                    break;
                }
                dir[nr][nc][idx%4]=true;
                idx++;
                r = nr;
                c = nc;
            }
        }
        System.out.println(cnt);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i)+" ");
        }
    }
}
