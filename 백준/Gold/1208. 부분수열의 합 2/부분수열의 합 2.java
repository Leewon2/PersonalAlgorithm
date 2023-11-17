

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int S;
    static int[] LArr;
    static int[] RArr;
    static List<Integer> L;
    static Map<Integer, Integer> R;
    static boolean[] visitL;
    static boolean[] visitR;
    static long res;

    public static void main(String[] args) throws IOException {
        input();
        leftPerm(0);
        rightPerm(0);
        L.sort((o1, o2) -> o1 - o2);
        twoPointer();

        if (N == 1 && R.get(S) != null) res = R.get(S);
        if (S == 0) res--;

        System.out.println(res);

    }

    private static void twoPointer() {
        int left = 0;
        while (left < L.size()) {
            if (R.get(L.get(left) * -1 + S) != null) res += R.get(L.get(left) * -1 + S);
            left++;
        }
    }

    private static void leftPerm(int idx) {
        if (idx == LArr.length) {
            int sum = 0;

            for (int i = 0; i < LArr.length; i++) {
                if (visitL[i]) {

                    sum += LArr[i];
                }
            }
            L.add(sum);
            return;
        }
        visitL[idx] = true;
        leftPerm(idx + 1);
        visitL[idx] = false;
        leftPerm(idx + 1);
    }

    private static void rightPerm(int idx) {
        if (idx == RArr.length) {

            int sum = 0;
            for (int i = 0; i < RArr.length; i++) {
                if (visitR[i]) {
                    sum += RArr[i];

                }
            }

            if (R.get(sum) == null) {
                R.put(sum, 1);
            } else {
                R.put(sum, R.get(sum) + 1);
            }
            return;
        }
        visitR[idx] = true;
        rightPerm(idx + 1);
        visitR[idx] = false;
        rightPerm(idx + 1);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        res = 0;
        if (N % 2 == 0) {

            LArr = new int[N / 2];
            RArr = new int[N / 2];
        } else {
            LArr = new int[N / 2];
            RArr = new int[N / 2 + 1];
        }
        L = new ArrayList<>();
        R = new HashMap<>();
        visitL = new boolean[LArr.length];
        visitR = new boolean[RArr.length];
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < N / 2; i++) {
            LArr[i] = arr[i];
        }
        for (int i = N / 2; i < N; i++) {
            RArr[i - N / 2] = arr[i];
        }
    }
}
