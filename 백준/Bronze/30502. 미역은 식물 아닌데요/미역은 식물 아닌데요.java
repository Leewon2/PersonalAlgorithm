

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int min = 0;
        int max = 0;
        boolean[] c = new boolean[N];
        int[] a = new int[N];
        int[] b = new int[N];
        Arrays.fill(c, true);
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt() - 1;
            char y = sc.next().charAt(0);
            int z = sc.nextInt();
            if (y == 'P') {
                if (z == 1)
                    a[x] = 2;
                else a[x] = 1;

            } else {
                if (z == 0)
                    b[x] = 2;
                else b[x]=1;
            }
            c[x] = false;
        }
        for (int i = 0; i < N; i++) {
            if (a[i]==2 && b[i]==2) {
                min++;
                max++;
            } else if ((a[i]==2 && b[i]==0) || (b[i]==2 && a[i]==0) || c[i]) max++;
        }
        System.out.println(min + " " + max);
    }
}
