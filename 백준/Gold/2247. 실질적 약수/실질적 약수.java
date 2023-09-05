
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long res=0;
        for (int i = 2; i <= n / 2; i++) {
            res= (res + (((n/i)-1)*i))%1000000;
        }
        System.out.println(res);
    }


}
