
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long idx = 2L;
        long sum=0L;
        if(A%2==1 || B%2==1){
            sum=(B-A)/2 +1;
        }else sum = (B-A)/2;
        if(A%2==0) A-=1;
        long minusA = ((A-1)/2) *2;

        while (idx < A) {
            idx*=2;
            if(idx>=A) break;
            long k = ((A-1)/idx) *idx - (idx/2)*((A-1)/idx);
            minusA+=k;

        }
//        System.out.println(minusA);

        idx = 2L;
        if(B%2==1) B-=1;
        sum+=B;
        while (idx <= B) {
            idx*=2;
            if(idx>B) break;
            long k = (B/idx) *idx - (idx/2)*(B/idx);
            sum+=k;
        }
//        System.out.println(sum);
        System.out.println(sum-minusA);
    }
}
