

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        double R = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        HashSet<Long> hashSet = new HashSet<>();
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        double[] number = new double[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            number[i] = Double.parseDouble(st.nextToken()) / 2;
        }
        Arrays.sort(number);
        for (int r = 0; r < N; r++) {
            for (int c = r + 1; c < N; c++) {
                long x = Math.abs(arr[r] - arr[c]);
                hashSet.add(x);
            }
        }
        List<Long> list = new ArrayList<>(hashSet);
        double max = 0;
        for (int i = 0; i < list.size(); i++) {
            long k = list.get(i);
            
            int idx = Arrays.binarySearch(number, R / k);
            if (idx < 0) {
                idx *= -1;
                idx -= 2;
            }
            if (idx >= 0)
                max = Math.max(max, k * number[idx]);
//            System.out.println(idx);
        }
//        System.out.println(Arrays.toString(new List[]{list}));
//        System.out.println(Arrays.toString(number));
        if (max != 0)
            System.out.println(String.format("%.1f", max));
        else System.out.println(-1);
    }
}
