

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] arr;
    static boolean[] isPrime;

    static int idx;

    static int N;


    public static void main(String[] args) {
        N = input();
        arr = new int[N];
        isPrime = new boolean[N+1];
        idx = 0;
        isPrime[0] = isPrime[1] = true;
        is_Prime();

        int start = 0;
        int end = 0;
        int cnt = 0;
//        System.out.println(Arrays.toString(arr));
        int res = prefix(start, end, cnt);
        System.out.println(res);

    }

    private static int prefix(int s, int e, int cnt) {
        int sum = 0;
        while (arr[s] <= N && arr[s]!=0 && e<=N/2) {

            // 시작점과 끝점이 같은 경우
            if (s == e) {
                sum = arr[s];
                // sum이 N보다 큰 경우
                if (sum > N) {
                    s++;
                    e++;
                }
                // sum이 N이랑 같은 경우
                else if (sum == N) {
                    cnt++;
                    s++;
                    e++;
                }

                // sum이 N보다 작은 경우
                else {
                    e++;
                }
            }

            // 시작점과 끝점이 다른 경우
            else {
                sum += arr[e];
                // 시작점과 끝점까지의 합이 N보다 큰 경우
                if(sum>N){
                    sum-=arr[s];
                    sum-=arr[e];
                    s++;
                }

                // 시작점과 끝점까지의 합이 N이랑 같은 경우
                else if(sum==N){
                    cnt++;
                    sum-=arr[s];
                    s++; e++;
                }

                // 시작점과 끝점까지의 합이 N보다 작은 경우
                else{
                    e++;
                }

            }

        }

        return cnt;
    }

    private static void is_Prime() {
        for (int i = 2; i <= N; i++) {
            if (!isPrime[i]) {
                arr[idx++] = i;
                for (int j = i; j <= N; j += i) {
                    isPrime[j] = true;
                }
            }
        }
    }

    private static int input() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        return n;
    }
}
