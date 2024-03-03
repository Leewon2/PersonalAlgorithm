import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static char[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N==1) System.out.println(0);
        else if(N*(N+1)/2 %3 !=0) System.out.println(0);
        else{
            int circle = N*(N+1)/2/3;
            int cnt=0;
            arr = new char[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < str.length(); j++) {
                    arr[i][j] = str.charAt(j);
                }
            }
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(arr[i][j]!='R' && arr[i][j]!='B') continue;
                    if(visited[i][j]) continue;
                    if(arr[i][j]=='R'){

                        cnt+=red(i,j,'R');
                    }else{
                        cnt+=blue(i,j,'B');
                    }
                }
            }
            if(cnt==circle) System.out.println(1);
            else System.out.println(0);


        }
    }
    private static int red(int r, int c, char color){
        if(r+1>=N || c+1>=N) return 0;
        if(arr[r+1][c]==color && !visited[r+1][c] && arr[r+1][c+1]==color && !visited[r+1][c+1]){
            visited[r][c]=true;
            visited[r+1][c] = true;
            visited[r+1][c+1] = true;
            return 1;
        }
        return 0;
    }
    private static int blue(int r, int c, char color){
        if(c-1<0 || r-1<0) return 0;

        if(arr[r-1][c]==color && !visited[r-1][c] && arr[r-1][c-1]==color && !visited[r-1][c-1]){
            visited[r][c] =true;
            visited[r-1][c] = true;
            visited[r-1][c-1] = true;
            return 1;
        }
        return 0;
    }
}
