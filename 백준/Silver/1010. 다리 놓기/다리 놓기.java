

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int t=0; t<tc; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());

            int k = Math.min(x, Math.abs(x-y));
            long sum=1;
//            System.out.println(k);
            for(int i=1; i<=k; i++){

                sum=(sum*(y-i+1))/i;
//                System.out.println("y : " + (y-i+1) + " i : "+i);

            }
            System.out.println(sum);
        }
    }
}
