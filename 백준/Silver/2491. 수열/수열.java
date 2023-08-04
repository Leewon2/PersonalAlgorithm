
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dpUp = new int[N];
        int[] dpDown = new int[N];
        dpUp[0]=dpDown[0]=1;
        int max=1;
        for (int i = 1; i < N; i++) {
            if(arr[i]>= arr[i-1]) dpUp[i]=dpUp[i-1]+1;
            else dpUp[i]=1;
            if(arr[i]<=arr[i-1]) dpDown[i]=dpDown[i-1]+1;
            else dpDown[i]=1;
            max = Math.max(dpUp[i], max);
            max = Math.max(dpDown[i], max);
        }
        System.out.println(max);
    }
}
