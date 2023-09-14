
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[] arr;



    public static void main(String[] args) throws IOException {
        input();
        int s =0;
        int e=0;
        int cnt=0;
        int res = twoPointer(s,e,cnt);
        System.out.println(res);
    }

    private static int twoPointer(int s, int e,int cnt){

        int sum=0;
        while (e < arr.length) {
            sum+=arr[e];
            while (sum > M && s != e) {
                sum-=arr[s];
                s++;
            }
            if(sum==M) cnt++;
            e++;
        }
        return cnt;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

    }
}
