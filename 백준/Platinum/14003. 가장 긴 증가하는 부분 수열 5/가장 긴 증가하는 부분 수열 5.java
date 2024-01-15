import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int max;
    static int[] numberArr;
    static int[] idxArr;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(calculate());
    }

    private static StringBuilder calculate() {
        StringBuilder sb = new StringBuilder();
        max = 0;
        int len = 0;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > numberArr[len]) {
                idxArr[i] = ++len;
                numberArr[len] = arr[i];
            } else {
                idx = binarySearch(0, len, arr[i]);
                numberArr[idx] = arr[i];
                idxArr[i] = idx;

            }
        }

        sb.append(len).append("\n");
        Stack<Integer> stack = new Stack<>();
        for (int i = N-1; i >= 0; i--) {
            if (idxArr[i] == len) {
                stack.add(arr[i]);
                len--;
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        return sb;
    }

    private static int binarySearch(int left, int right, int find) {
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (numberArr[mid] < find) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        numberArr = new int[N+1];
        idxArr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        numberArr[0] = Integer.MIN_VALUE;


    }
}