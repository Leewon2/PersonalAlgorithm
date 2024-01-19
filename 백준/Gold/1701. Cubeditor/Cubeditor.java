
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        char[] arr = br.readLine().toCharArray();
        String str = br.readLine();
        int res=0;
        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(i, str.length());
            res = Math.max(res, KMP(s));
        }
        System.out.println(res);

    }

    private static int KMP(String s) {
        int len = s.length();
        int[] pi = new int[len];
        int j = 0;
        int max = 0;
        for (int i = 1; i < len; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pi[j - 1];
            }
            if (s.charAt(i)== s.charAt(j)) {
                pi[i] = ++j;
                max = Math.max(max, pi[i]);
            }
        }
//        System.out.println(Arrays.toString(pi));
        return max;
    }

    private static boolean equal(char[] arr, int x, int y) {
        if (arr[x] == arr[y]) return true;
        return false;
    }
}
