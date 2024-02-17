import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            int[] number = new int[10001];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                number[arr[i]]++;
            }
            int[] copyArr = arr.clone();
            Arrays.sort(copyArr);
            int maxIdx = n - 1;
            long sum = 0;
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                while (true) {
                    if (number[copyArr[maxIdx]] == 0) {
                        maxIdx--;
                    }else break;
                }
                if (arr[i] == copyArr[maxIdx]) {
                    while (!q.isEmpty()) {
                        sum += (arr[i] - q.poll());
                    }
                    number[arr[i]]--;
                    maxIdx--;
                } else {
                    number[arr[i]]--;
                    q.offer(arr[i]);
                }
            }

            sb.append(sum).append("\n");
        }
        System.out.println(sb);


    }


}

