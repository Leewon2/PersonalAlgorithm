
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cnt=0;

        // i : B
        // j : A
        for (int i = 1; i <= 500; i++) {
            for (int j = i; j <= 500; j++) {
                if(i*i == j*j - n) cnt++;
                if(i*i<j*j-n) break;
            }
        }
        System.out.println(cnt);
    }
}
