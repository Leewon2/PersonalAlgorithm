

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main{

    static int[][] arr;
    static int[][] number;
    static boolean[][] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][5];
        number = new int[5][5];
        visited = new boolean[5][5];
        result = 0;
        int res=0;
        for (int r = 0; r < 5; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 5; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        for (int r = 0; r < 5; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 5; c++) {
                number[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        outer : for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                findNum(r, c);
                checkBingo();
                if(result>2){
//                    System.out.println("r : "+r + " c : " +c);
                    res=5*r+c+1;
                    break outer;
                }
            }
        }
        System.out.println(res);

    }

    static void findNum(int row, int col) {
        int x = number[row][col];
        outer:
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (arr[r][c] == x) {
                    visited[r][c] = true;
                    break outer;
                }
            }
        }
    }

    static void checkBingo() {
        result = 0;
        for (int r = 0; r < 5; r++) {
            boolean check = true;
            for (int c = 0; c < 5; c++) {
                if (!visited[r][c]) {
                    check = false;
                    break;
                }
            }
            if (check) result++;
        }
        for (int c = 0; c < 5; c++) {
            boolean check = true;
            for (int r = 0; r < 5; r++) {
                if (!visited[r][c]) {
                    check = false;
                    break;
                }
            }
            if (check) result++;
        }
        boolean check = true;
        for (int r = 0; r < 5; r++) {

            if (!visited[r][r]) {
                check = false;
                break;
            }

        }
        if (check) result++;
        check = true;
        for (int r = 0; r < 5; r++) {

            if (!visited[4-r][r]) {
                check = false;
                break;
            }

        }
        if (check) result++;
    }
}
