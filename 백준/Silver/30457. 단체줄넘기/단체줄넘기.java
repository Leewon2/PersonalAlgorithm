

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        boolean[] visited = new boolean[N];
        int res = 1;
        visited[0] = true;
        int max = arr[0];
        for (int i = 2; i < N; i++) {
            if (!visited[i] && arr[i] < max) {
                max = arr[i];
                visited[i] = true;
                res++;
            }
        }
        if (N > 1) {
            res++;
            max = arr[1];
            for (int i = 1; i < N; i++) {
                if (!visited[i] && arr[i] < max) {
                    max = arr[i];
                    visited[i] = true;
                    res++;
                }
            }
        }
        System.out.println(res);
    }

}
