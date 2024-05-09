import java.util.Scanner;

public class Main {
    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[][] arr = new boolean[101][101];
        for (int i = 0; i < 4; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            for (int r = x1; r < x2; r++) {
                for (int c = y1; c < y2; c++) {
                    arr[r][c] = true;
                }
            }
        }
        int res=0;
        for (int r = 1; r <= 100; r++) {
            for (int c = 1; c <= 100; c++) {
                if(arr[r][c]) res++;
            }
        }
        System.out.println(res);

    }

}