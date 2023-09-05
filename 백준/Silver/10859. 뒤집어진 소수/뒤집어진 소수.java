
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N = sc.next();

        boolean checkPrime = true;



        for (int i = 0; i < N.length(); i++) {
            int k = Character.getNumericValue(N.charAt(i));
            if (k == 3 || k == 4 || k == 7) {
                checkPrime = false;
                break;
            }
        }
        if (checkPrime) {
            long k = Long.parseLong(N);
            if(k==1) checkPrime=false;
            if (!isPrime(k)) checkPrime = false;
        }
        String compare = "";
        if (checkPrime) {
            for (int i = N.length() - 1; i >= 0; i--) {
                char k = N.charAt(i);
                if(k=='6') k='9';
                else if(k=='9') k='6';
                compare += k;
            }
            long k = Long.parseLong(compare);
            if(k==1) checkPrime=false;
            if (!isPrime(k)) checkPrime = false;
        }
        System.out.println(checkPrime ? "yes" : "no");


    }

    private static boolean isPrime(long x) {
        long idx = 2L;
        while (x != 1) {
            if (idx > 100000000 || idx == x) {
                return true;
            }
            if (x % idx == 0)
                return false;
            idx++;
        }
        return true;
    }
}
