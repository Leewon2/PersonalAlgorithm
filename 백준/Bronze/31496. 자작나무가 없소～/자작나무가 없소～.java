import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String str = st.nextToken();
        int cnt=0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int count = Integer.parseInt(st.nextToken());
            String[] arr = s.split("_");
            for (int j = 0; j < arr.length; j++) {
                if(arr[j].equals(str)){
                    cnt+=count;
                    break;
                }
            }
        }
        System.out.println(cnt);

    }
}
