import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        long low = 1;
        long high = arr[N-1];
        long mid=0;
        while(low<=high){

            mid = (high+low)/2;
            int now=0;
            int cnt=1;
            for (int i = 1; i < N; i++) {
                if(arr[i]-arr[now]>=mid){
                    now = i ;
                    cnt++;
                }
            }
            if(cnt<C) {
                high = mid-1;
                continue;
            }
            low=mid+1;

        }
        System.out.println(low-1);

    }
}
