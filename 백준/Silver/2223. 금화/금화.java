

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int x = sc.nextInt();
        int m = sc.nextInt();
        int min =Integer.MAX_VALUE;
        boolean check = false;
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a<=b) check = true;
            int k = a/b;
            if(a%b==0) k--;
            min = Math.min(min,k);
        }
        int res = Math.min(min,t) * x;
        if (t -min> 1) {
            res += (t-min)/2 * x;
        }
        if(check) res=0;
        System.out.println(res);
    }
}
