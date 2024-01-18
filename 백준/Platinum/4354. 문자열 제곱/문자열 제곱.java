
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String str = br.readLine();
            if(str.equals(".")) break;
            sb.append(KMP(str)).append("\n");
        }
        System.out.println(sb);
    }

    private static int KMP(String str){
        int j = 0;
        int max=0;
        int len = str.length();
        int[] pi = new int[len];
        for (int i = 1; i < len; i++) {
            while(j>0 && str.charAt(i) != str.charAt(j)){
                j = pi[j-1];
            }
            if(str.charAt(i)==str.charAt(j)){
                pi[i]=++j;
            }
        }
        return len % (len - pi[len - 1]) != 0 ? 1 : len / (len - pi[len - 1]);
    }
}
