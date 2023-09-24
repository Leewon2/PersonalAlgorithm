

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int[] arr = new int[N];
        Arrays.fill(arr, K);
        int cnt = 0;
        while (true) {
            if (count(arr)) break;

            for (int i = 0; i < A; i++) {
                arr[i] += B;
            }
            for (int i = 0; i < N; i++) {
                arr[i]--;
            }
            Arrays.sort(arr);
            cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean count(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                return true;
            }
        }
        return false;
    }
}
