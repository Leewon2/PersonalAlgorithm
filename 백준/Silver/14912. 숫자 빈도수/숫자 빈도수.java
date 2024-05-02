import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] arr = new int[10];
        for (int i = 1; i <= n; i++) {
            String s = Integer.toString(i);
            for (int j = 0; j < s.length(); j++) {
                arr[Character.getNumericValue(s.charAt(j))]++;
            }
        }
        System.out.println(arr[d]);
    }
}
