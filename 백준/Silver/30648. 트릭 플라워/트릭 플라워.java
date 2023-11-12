

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[R][R];
        arr[r][c]=true;
        int res=0;
        while(true){
            res++;
            if(r+c+2<R){
                r+=1;
                c+=1;
            }else{
                r/=2;
                c/=2;
            }
            if(arr[r][c]) break;
            arr[r][c]=true;
        }
        System.out.println(res);

    }
}
