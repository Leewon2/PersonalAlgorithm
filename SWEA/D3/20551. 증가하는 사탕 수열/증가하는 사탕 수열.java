import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            int[] arr = new int[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = sc.nextInt();
            }
            int cnt=0;
            for (int i = 2; i >= 1; i--) {
                if(arr[i]>arr[i-1]) continue;
                int k = arr[i]-1;
                if(k<1) {
                    cnt=-1;
                    break;
                }
                cnt += arr[i - 1] - k;
                arr[i-1]=k;
            }
            sb.append(cnt).append("\n");

        }
        System.out.println(sb);
    }
}
