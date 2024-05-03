import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        String[] subArr = arr.clone();
        Arrays.sort(subArr);
        boolean check = true;
        for (int i = 0; i < n; i++) {
            if(!arr[i].equals(subArr[i])) {
                check =false;
                break;
            }
        }
        if(check) System.out.println("INCREASING");
        else{
            check = true;
            for (int i = 0; i < n; i++) {
                if(!arr[i].equals(subArr[n-i-1])) {
                    check =false;
                    break;
                }
            }
            if(check) System.out.println("DECREASING");
            else System.out.println("NEITHER");
        }
    }
}
