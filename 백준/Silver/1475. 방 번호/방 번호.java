
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        int[] arr = new int[10];
        for (int i = 0; i < N.length(); i++) {

            int x = Character.getNumericValue(N.charAt(i));
            if(x==9) arr[6]++;
            else arr[x]++;
        }
        if(arr[6]%2!=0) arr[6]=arr[6]/2 +1;
        else arr[6]/=2;
        int max=0;
        for (int i = 0; i < 10; i++) {
            max = Math.max(arr[i], max);
        }
        System.out.println(max);

    }
}
