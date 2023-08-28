

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        int w = sc.nextInt();

        int cnt = 0;
        int sheep = 0;
        int goat = 0;
        for (int i = 1; i < n; i++) {
            if (i * a + (n - i) * b == w) {
                cnt++;
                sheep = i;
                goat = n - i;
            }
        }
        if (cnt != 1) {
            System.out.println(-1);
        } else {
            System.out.println(sheep + " " + goat);
        }
    }
}
