import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
        int sum=0;
        for (int i = 0; i < 5; i++) {
            int k = Integer.parseInt(br.readLine());
            
            if(k<=40) k=40;
            sum += k;
        }
        System.out.println(sum/5);

    }



}


//
/*
 * 2143
 * 3412
 * */
