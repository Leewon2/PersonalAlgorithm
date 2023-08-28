
import javax.jws.soap.SOAPBinding;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = (int) Math.sqrt(A * A - B);


        int resA = -1 * A + C;
        int resB = -1 * A - C;
        if (resA > resB) {
            int temp = resA;
            resA = resB;
            resB =temp;
        }

        if (resA == resB) {
            System.out.println(resA);
        } else {
            if(resA+resB != -1*2*A || resA*resB!=B) System.out.println(-1);
            else System.out.println(resA + " " + resB);

        }


    }
}