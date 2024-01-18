
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        System.out.println(N - KMP(arr, N));
    }

    private static int KMP(char[] arr, int N) {
        int[] pi = new int[N];
        int j=0;
        for (int i = 1; i < N; i++) {
            while (j > 0 && arr[i] != arr[j]) {
                j = pi[j-1];
            }
            if(arr[i]== arr[j]){
                pi[i] = ++j;
            }
        }
        return pi[N-1];
    }
}
