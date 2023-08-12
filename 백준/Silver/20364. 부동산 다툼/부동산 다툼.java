

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[N + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= Q; i++) {
            boolean check = true;
            int min = 200000;
            int find = Integer.parseInt(br.readLine());
            int temp = find;
            while (temp > 1) {

                if (arr[temp]) {
                    check = false;
                    min = temp;
                }
                temp /= 2;
            }
            if (check) {
                sb.append(0).append("\n");
                arr[find] = true;
            } else {
                sb.append(min).append("\n");
            }
            
        }

//        System.out.println(Arrays.toString(arr));
        System.out.println(sb);

    }
}
