import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        System.out.println(lcm(a, b));
    }
    private static long gcd(long x, long y){
        while(y>0){
            long k = x;
            x=y;
            y=k%y;
        }
        return x;

    }
    private static long lcm(long x, long y){
        return (x*y)/gcd(x,y);
    }


}


//
/*
 * 2143
 * 3412
 * */
