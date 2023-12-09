import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        long sum=0;
        for (int i = 0; i < A.length(); i++) {
            int k = Character.getNumericValue(A.charAt(i));
            for (int j = 0; j < B.length(); j++) {
                sum += k * Character.getNumericValue(B.charAt(j));
            }
        }
        System.out.println(sum);
    }
}