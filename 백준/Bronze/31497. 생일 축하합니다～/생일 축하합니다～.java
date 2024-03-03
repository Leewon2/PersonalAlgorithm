import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLine();
        }
        String res="";
        int len=arr.length-1;
        outer : while(len>=0){
            int before=-1;
            for (int i = 0; i < 2; i++) {
                System.out.println("? "+arr[len]);
 
                int k = sc.nextInt();
                if(i==0){
                    before = k;
                }else{
                    if(before==1 && k==1){
                        res = arr[len];
                        break outer;
                    }
                    else{
                        if (before != k) {
                            res=arr[len];
                        }
                    }
                }

            }
            len--;
        }
        System.out.println("! "+res);

    }
}
