

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long k = Long.parseLong(br.readLine());


        StringBuilder sb = new StringBuilder();
        int idx=2;
        int cnt=0;
        while (k != 1) {
            if (idx > 1000000) {
                cnt++;
                sb.append(k).append(" ");
                break;
            }
            while (k % idx == 0) {
                sb.append(idx).append(" ");
                cnt++;
                k/=idx;
            }
            idx++;
        }
        System.out.println(cnt);
        System.out.println(sb);


    }

}
