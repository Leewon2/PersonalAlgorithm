
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cnt=0;
        // i : 남규(영훈이보다 2개 이상 많아야 함)
        for (int i = 3; i <= n - 2; i++) {
            // j : 영훈
            for (int j = 1; j <= i - 2; j++) {
                // k : 택희
                int k = n-i-j;
                if(k<=0 && k%2==0){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
