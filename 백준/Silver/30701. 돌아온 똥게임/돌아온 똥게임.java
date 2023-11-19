
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        BigInteger D = new BigInteger(st.nextToken());
        int[][] arr = new int[N][2];
        int mon = 0;
        int eq = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            if (arr[i][0] == 1) mon++;
            else eq++;
        }
        BigInteger[] monster = new BigInteger[mon];
        BigInteger[] equ = new BigInteger[eq];
        int monidx = 0;
        int eqidx = 0;
        for (int i = 0; i < N; i++) {
            int k = arr[i][0];
            if (k == 1) {
                monster[monidx++] = BigInteger.valueOf(arr[i][1]);
            } else {
                equ[eqidx++] = BigInteger.valueOf(arr[i][1]);
            }
        }

        Arrays.sort(monster);
        Arrays.sort(equ);
        int res = 0;
        int idx = 0;
        for (int i = 0; i < monster.length; i++) {
//            System.out.println(" monster : " + monster[i] + " D : "+D);
            if (monster[i].compareTo(D) >= 0) {

                if (idx >= eqidx) break;
                D = D.multiply(equ[idx++]);
                res++;
                i--;
            } else {
                D = D.add(monster[i]);
                res++;
            }
//            System.out.println("idx : " + idx + " monster : " + monster[i] + " D : "+D+" res : "+res);
        }
        for (int i = idx; i < eqidx; i++) {
            res++;
        }
        System.out.println(res);
//        System.out.println(Arrays.toString(monster));
//        System.out.println(Arrays.toString(equ));
    }
}
