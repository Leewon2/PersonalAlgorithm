import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] arr = new int[2000];
        int[] num = new int[N];
        int cnt=0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        if(L==1){
            System.out.println(num.length);
            System.exit(0);
        }
        Arrays.sort(num);
        for (int i = 0; i < N; i++) {
            int k = num[i];
            if(arr[k]==1){
                for (int j = k + 1; j <= k + L; j++) {
                    arr[j]=2;
                }
                arr[k+L+1]=1;
                cnt++;
            }else if(arr[k]==2) continue;
            else{
                for (int j = k; j < k + L; j++) {
                    arr[j]=2;
                }
                arr[k+L]=1;
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}
