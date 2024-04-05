import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = 300;
        int b = 60;
        int c = 10;
        int A = n/a;
        n%=a;
        int B = n/b;
        n%=b;
        int C = n/c;
        n%=c;
        if(n!=0) System.out.println(-1);
        else{
            System.out.println(A+" "+B+" "+C);
        }
    }


}
