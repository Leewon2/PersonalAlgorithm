import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int start =0;
        int end=1;
        int cnt=0;
        int sum=1;
        while(end<=n){
            if(sum == n) {
                cnt++;
                end++;
                sum+=end;

            }else if(sum>n){
                sum-=start;
                start++;
            }else{
                end++;
                sum+=end;
            }
        }
        System.out.println(cnt);
    }

}

