

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] arr = st.nextToken().toCharArray();
        long n = Long.parseLong(st.nextToken())-1;
        System.out.println(arr.length + KMP(arr)*n);

    }

    private static int KMP(char[] arr) {
        int[] pi = new int[arr.length];
        int j=0;
        for (int i = 1; i < arr.length; i++) {
            while (j > 0 && arr[i] != arr[j]) {
                j = pi[j-1];
            }
            if (arr[i] == arr[j]) {
                pi[i] = ++j;
            }
        }
        return arr.length-pi[arr.length - 1];
    }
}
