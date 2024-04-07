import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int idx;
    static int[] operator;
    static int N;
    static int[] number;
    static boolean[] visited;
    static int[] compare;
    static int max,min;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        number = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());

        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        visited = new boolean[N - 1];
        operator = new int[N - 1];
        compare = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        int aCnt = Integer.parseInt(st.nextToken());
        int bCnt = Integer.parseInt(st.nextToken());
        int cCnt = Integer.parseInt(st.nextToken());
        int dCnt = Integer.parseInt(st.nextToken());
        idx = 0;
        input(aCnt, 0);
        input(bCnt, 1);
        input(cCnt, 2);
        input(dCnt, 3);
        perm(0);
        System.out.println(max);
        System.out.println(min);
    }

    private static void input(int cnt, int num) {
        for (int i = 0; i < cnt; i++) {
            operator[idx++] = num;
        }
    }

    private static void calculate(){
        int sum=number[0];
        for (int i = 1; i < N; i++) {
            int x = number[i];
            switch (compare[i-1]){
                case 0:
                    sum+=x;
                    break;
                case 1:
                    sum-=x;
                    break;
                case 2:
                    sum*=x;
                    break;
                case 3:
                    sum/=x;
                    break;
            }
        }
        max = Math.max(max, sum);
        min = Math.min(min, sum);
    }

    private static void perm(int index) {
        if (index == N - 1) {

            calculate();
            return;
        }
        for (int i = 0; i < N - 1; i++) {
            if (visited[i]) continue;
            compare[index] = operator[i];
            visited[i] = true;
            perm(index + 1);
            visited[i] = false;
        }

    }
}
