

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        boolean check = false;
        int[] arr = new int[10];
        int sum=0;
        for(int i=0; i<str.length(); i++){
            int x = Character.getNumericValue(str.charAt(i));
            sum+=x;
            if(x==0) check=true;
            arr[x]++;
        }
        StringBuilder sb = new StringBuilder();
        if(check && sum%3==0){
            for (int i = 9; i >= 0; i--) {
                for (int j = 0; j < arr[i]; j++) {
                    sb.append(i);
                }
            }
        }else{
            sb.append("-1");
        }
        System.out.println(sb);


    }
}
