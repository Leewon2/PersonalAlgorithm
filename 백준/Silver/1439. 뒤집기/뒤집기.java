import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[2];
        int len = 0;
        while(len<str.length()){
            char k = str.charAt(len);
            len++;
            while(len<str.length()){
                if(str.charAt(len)!=k) break;
                len++;
            }
            arr[Character.getNumericValue(k)]++;
        }
        System.out.println(Math.min(arr[0],arr[1]));
    }
}
