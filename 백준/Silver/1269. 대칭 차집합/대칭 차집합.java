import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        Map<Integer, Integer> Amap = new HashMap<>();
        Map<Integer, Integer> Bmap = new HashMap<>();
        int res=0;
        for (int i = 0; i < A; i++) {
            int k = sc.nextInt();
            if (Amap.get(k) == null) {
                Amap.put(k, 1);
            }else{
                Amap.put(k,Amap.get(k)+1);
            }
        }
        int res2=A;
        for (int i = 0; i < B; i++) {
            int k = sc.nextInt();
            if (Bmap.get(k) == null) {
                Bmap.put(k, 1);
            }else{
                Bmap.put(k,Bmap.get(k)+1);
            }
            if(Amap.get(k)==null) {
                res++;
            }else res2--;
        }

        System.out.println(res+res2);



    }
}
