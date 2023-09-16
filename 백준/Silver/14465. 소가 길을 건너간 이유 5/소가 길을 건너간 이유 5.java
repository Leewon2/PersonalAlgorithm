

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        boolean[] breakSignal = new boolean[N + 1];

        for (int i = 0; i < B; i++) {
            breakSignal[Integer.parseInt(br.readLine())] = true;
        }
        // 고장난 신호등 갯수 세기
        int breakCnt = 0;

        // 결과가 될 최소값
        int min = 9876561;

        // 시작점, 끝점, 갯수
        int start = 1;


        for (int i = 1; i <= N; i++) {

            if (breakSignal[i]) breakCnt++;
            if (i-start+1 == K) {
                min = Math.min(min, breakCnt);
                while (start != i) {
                    if (breakSignal[start]) {
                        breakCnt--;

                        start++;

                        break;
                    } else {
                        start++;
                    }
                }
            }




        }
        System.out.println(min);
    }
}
