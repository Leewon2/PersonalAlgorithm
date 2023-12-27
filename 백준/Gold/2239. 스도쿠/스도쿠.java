
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int[][] arr;
    static boolean[][] row;
    static boolean[][] col;

    static boolean doNotSave;
    static List<int[]> zeroList;


    public static void main(String[] args) throws IOException {
        input();
        dfs(0);
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                System.out.print(arr[r][c]);
            }
            System.out.println();
        }
    }

    private static void dfs(int cnt) {
        if (doNotSave) return;
        if (cnt == zeroList.size()) {

            doNotSave = true;
            return;
        }
        int[] list = zeroList.get(cnt);
        int r = list[0];
        int c = list[1];
        for (int i = 1; i <= 9; i++) {
            if(checkSameNumber(r,c,i)){
                arr[r][c]=i;
                row[r][i]=true;
                col[c][i]=true;
                dfs(cnt+1);
                if(doNotSave) return;
                arr[r][c]=0;
                row[r][i]=false;
                col[c][i]=false;
            }
        }

    }


    // x는 행, y는 열, k는 값
    private static boolean checkSameNumber(int x, int y, int k) {

        // x번째/y번째 행/열에 k 값이 있는가?
        if (row[x][k]) return false;
        if (col[y][k]) return false;

        int nx = 0;
        int ny = 0;

        if (x >= 6) {
            nx = 6;
        } else if (x >= 3) {
            nx = 3;
        }

        if (y >= 6) {
            ny = 6;
        } else if (y >= 3) {
            ny = 3;
        }
        for (int r = nx; r < nx + 3; r++) {
            for (int c = ny; c < ny + 3; c++) {
                if (arr[r][c] == k) return false;
            }
        }


        return true;
    }

    // 상 하 사각형 안에 같은 숫자가 있는지 확인
    // 같은게 없다면 일단 들어갈 수 있음


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        doNotSave = false;
        arr = new int[9][9];
        row = new boolean[9][10];
        col = new boolean[9][10];
        zeroList = new ArrayList<>();
        for (int r = 0; r < 9; r++) {
            String str = br.readLine();
            for (int c = 0; c < 9; c++) {
                arr[r][c] = Character.getNumericValue(str.charAt(c));
                if (arr[r][c] != 0) {
                    row[r][arr[r][c]] = true;
                    col[c][arr[r][c]] = true;
                } else {
                    zeroList.add(new int[]{r, c});
                }
            }
        }
        // 0번째 행의 숫자가 true인가?
    }
}
