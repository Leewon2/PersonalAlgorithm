
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());


        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int start =0;
        int end = n-1;
        int k = Integer.parseInt(br.readLine());
        int cnt=0;
        while (start < end) {
            if(arr[start]+arr[end]>k){
                end--;
            }
            else if(arr[start]+arr[end]==k){
                cnt++;
                start++;
                end--;
            }else{
                start++;
            }
        }
        System.out.println(cnt);


    }
}
