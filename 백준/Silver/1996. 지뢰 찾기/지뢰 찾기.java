

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dr = {1,0,-1,0,1,1,-1,-1};
    static int[] dc = {0,1,0,-1,1,-1,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        int[][] map = new int[N][N];
        char[][] res = new char[N][N];
        for (int r = 0; r < N; r++) {
            String str = br.readLine();
            for (int c = 0; c < N; c++) {
                arr[r][c] = str.charAt(c);
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (arr[r][c] - '1' >= 0 && arr[r][c] - '1' <= 9) {
                    for (int i = 0; i < 8; i++) {
                        int nr = r+dr[i];
                        int nc = c+dc[i];
                        if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
                        map[nr][nc]+=arr[r][c]-'0';
                    }
                }
            }
        }
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (arr[r][c] - '1' >= 0 && arr[r][c] - '1' <= 9){
                    res[r][c]='*';
                }else {
                    if(map[r][c]>=10){
                        res[r][c] = 'M';
                    }else{
                        res[r][c]=Character.forDigit(map[r][c],10);
                    }
                }
            }
        }
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(res[r][c]);
            }
            System.out.println();
        }
    }
}
