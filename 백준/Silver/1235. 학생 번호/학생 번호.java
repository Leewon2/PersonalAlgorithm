
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        String[] compare = new String[N];
        Arrays.fill(compare,"");
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        int res=0;
        outer : for (int i = arr[0].length() - 1; i >= 0; i--) {
            res++;
            Queue<String> q = new LinkedList<>();
            q.offer("-1");
            boolean check = true;
            for (int j = 0; j < N; j++) {
                compare[j] += arr[j].charAt(i);
                if(q.contains(compare[j])){
                    check=false;
                }
                q.offer(compare[j]);
            }
            if(check){
                break outer;
            }
        }
        System.out.println(res);
    }
}
