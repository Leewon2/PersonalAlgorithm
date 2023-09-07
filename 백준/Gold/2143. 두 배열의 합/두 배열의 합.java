
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());


        Map<Integer, Integer> map = new HashMap<>();


        int an = Integer.parseInt(br.readLine());
        int[] arr = new int[an];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < an; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < an; i++) {
            int sum=0;
            for (int j = i; j < an; j++) {
                sum+=arr[j];
                map.put(sum, map.get(sum) == null ? 1 : map.get(sum) + 1);
            }
        }

        int bn = Integer.parseInt(br.readLine());
        int[] brr = new int[bn];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bn; i++) {
            brr[i] = Integer.parseInt(st.nextToken());
        }

        long cnt=0;
        for (int i = 0; i < bn; i++) {
            int sum=0;
            for (int j = i; j < bn; j++) {
                sum+=brr[j];
                if(map.get(t-sum)!=null)
                cnt+=map.get(t-sum);
            }
        }
        System.out.println(cnt);

    }
}
