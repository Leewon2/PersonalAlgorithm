
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[r][c];
        int[] number = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        int idx=0;
        int res=0;
        Arrays.sort(number);
        outer :
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                if(idx>=N) break outer;
                if(row>0){
                    while(true){
                        if(idx>=N) break outer;
                        if(arr[row-1][col]<number[idx]){
                            arr[row][col] = number[idx++];
                            res++;
                            break;
                        }
                        else{
                            idx++;
                        }
                    }
                }else{
                    arr[row][col] = number[idx++];
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
