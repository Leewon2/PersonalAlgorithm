
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String N = sc.next();
            if (N.equals("0")) break;
            int sum=N.length()+1;
            for (int i = 0; i < N.length(); i++) {
                int k = Character.getNumericValue(N.charAt(i));
                if(k==1) sum+=2;
                else if(k==0) sum+=4;
                else sum+=3;
            }
            System.out.println(sum);


        }
    }
}
