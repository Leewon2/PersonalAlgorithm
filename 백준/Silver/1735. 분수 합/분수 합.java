


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstA = Integer.parseInt(st.nextToken());
        int firstB = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int lastA = Integer.parseInt(st.nextToken());
        int lastB = Integer.parseInt(st.nextToken());
        int x = firstA * lastB + firstB * lastA;
        int y = firstB * lastB;
        int resX = x;
        int resY = y;
        resX/=GCD(x,y);
        resY/=GCD(x,y);
        System.out.println(resX+" "+resY);
        

    }

    private static int GCD(int x, int y){
        while (x != 0 && y != 0) {
            if (x > y) {
                int temp = y;
                y = x;
                x = temp;

            }
            y-=x;
        }
        if(x!=0) return x;
        else return y;
    }
}
