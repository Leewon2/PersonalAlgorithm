

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();

        int res=1;

        int start = 64;

        while (start!=X) {
            if (start >> 1 < X){
                res++;
                X-= start>>1;
            }
            start>>=1;

        }
        System.out.println(res);
    }
}
