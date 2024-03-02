import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long k = Long.parseLong(br.readLine());
            if (map.get(k) != null) {
                map.put(k, map.get(k) + 1);
            } else {
                map.put(k, 1L);
            }
        }
        long max = 0;
        long idx = 0;
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            Long key = entry.getKey();
            Long value = entry.getValue();
            if (value > max) {
                max = value;
                idx = key;
            }else if(value==max){
                if(idx>key){
                    idx=key;
                }
            }
        }
        System.out.println(idx);
    }
}
