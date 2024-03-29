
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < tc; t++) {
            long sum=0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());

            }
            
            for (int i = 0; i < n-1; i++) {
                for (int j = i + 1; j < n; j++) {
                    sum+=GCD(arr[i],arr[j]);
                }
            }

            sb.append(sum).append("\n");

        }
        System.out.println(sb);
    }

    private static int GCD(int x, int y){
        while(x!=0 && y!=0){
            if(x>y){
                int temp = y;
                y = x;
                x =temp;
            }
            y-=x;
        }
        if(x>0) return x;
        else return y;
    }
}
