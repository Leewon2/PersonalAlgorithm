

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean check = false;
        // i : A
        outer : for (int i = 0; i <= 50; i++) {
            if(i*A >N) break;
            // j : B
            for (int j = 0; j <= 50; j++) {
                if(j*B>N) break;
                // K : C
                for (int k = 0; k <= 50; k++) {
                    if (k * C > N) break;
                    if(i*A + j*B + k*C == N) {
                        check =true;
                        break outer;
                    }
                }
            }
        }
        System.out.println(check ? 1 : 0);
    }
}
