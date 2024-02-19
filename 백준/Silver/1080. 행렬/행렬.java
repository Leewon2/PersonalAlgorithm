import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] A;
    static char[][] B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        A = new char[n][m];
        B = new char[n][m];
        for (int i = 0; i < n; i++) {
            A[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            B[i] = br.readLine().toCharArray();
        }
        int cnt=0;
        for (int r = 0; r <= n - 3; r++) {
            for (int c = 0; c <= m - 3; c++) {
                if(A[r][c]!=B[r][c]){
                    change(r, c);
                    cnt++;
                }
            }
        }
        if(checkSameArray(n,m)) System.out.println(cnt);
        else System.out.println(-1);



    }
    private static boolean checkSameArray(int n, int m){
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if(A[r][c]!=B[r][c]) return false;
            }
        }
        return true;
    }
    private static void change(int r, int c){
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if(A[i][j]=='1') A[i][j]='0';
                else A[i][j]='1';
            }
        }
    }
}

