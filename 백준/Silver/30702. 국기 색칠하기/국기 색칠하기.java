
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int[] dr={1,0,-1,0};
    static final int[] dc={0,1,0,-1};
    static boolean[][] visited;
    static boolean[][] visited2;
    static int N;
    static int M;
    static char[][] A;
    static char[][] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new char[N][M];
        B = new char[N][M];
        visited = new boolean[N][M];
        visited2 = new boolean[N][M];
        input(A,br);
        input(B,br);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(A[i][j] != B[i][j] && !visited[i][j]){
                    visited[i][j]= true;
                    visited2[i][j]= true;
                    dfs(i,j);
                    change(B[i][j]);
                }
            }
        }
        System.out.println(calculate());


    }
    private static String calculate(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(A[i][j] != B[i][j]) return "NO";
            }
        }
        return "YES";
    }

    private static void change(char X){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited2[i][j]){
                    A[i][j] = X;
                }
            }
        }
        visited2 = new boolean[N][M];



    }
    private static void dfs(int r, int c){

        for (int i = 0; i < 4; i++) {
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
            if(!visited[nr][nc] && A[r][c]==A[nr][nc]){
                visited[nr][nc]=true;
                visited2[nr][nc]=true;
                dfs(nr,nc);
            }
        }
    }

    private static void input(char[][] arr, BufferedReader br) throws IOException {

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
    }
}
