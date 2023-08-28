

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];

        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int sum=0;
        for (int i = 0; i < 10; i++) {
            int compare = sum+arr[i];
            if(Math.abs(100-sum) >=Math.abs(100-compare)){
                sum=compare;
            }else{
                break;
            }
        }
        System.out.println(sum);
    }
}
