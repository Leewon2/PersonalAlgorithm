

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static char[][] arr;

    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], ' ');
        }

        recursion(0, 0, N);
        
        StringBuilder sb = new StringBuilder();
        
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                sb.append(arr[row][col]);
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }

    private static void recursion(int x, int y, int data) {
    	int nextData = data / 3;
        if (data == 1) {
            arr[x][y] = '*';
            return;
        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }

                recursion(x + i * nextData, y + j * nextData, nextData);
            }
        }
    }
}
