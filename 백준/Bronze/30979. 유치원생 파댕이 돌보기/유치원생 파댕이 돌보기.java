import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum += sc.nextInt();
        }
        if(t<=sum){
            System.out.println("Padaeng_i Happy");
        }else{
            System.out.println("Padaeng_i Cry");
        }


    }
}
