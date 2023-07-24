

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long max=0;
        long min = 1000000;
        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            max = Math.max(x, max);
            min = Math.min(x, min);
        }
        System.out.println(max*min);
    }
}
