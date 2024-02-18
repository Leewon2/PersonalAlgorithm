import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s.length() == 1) {
            System.out.println(s);
            System.exit(0);
        }

        long k = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            long x = 1;
            if (i == 0) {
                k += 9;
            } else {
                for (int j = 0; j < i; j++) {
                    x*=10;
                }
                k+=9*x*(i+1);
            }
        }
        String sub = "";
        for (int i = 0; i < s.length() - 1; i++) {
            sub+="9";
        }
        long sum = (Long.parseLong(s)-Long.parseLong(sub)) * s.length();
        System.out.println(k + sum);

    }
}

