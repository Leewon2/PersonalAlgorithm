import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long C = Long.parseLong(st.nextToken());
        long D = Long.parseLong(st.nextToken());
        long K = Long.parseLong(br.readLine());

        long doldol = A+C;
        long doldolDist = 0;
        if(doldol%D!=0){
            doldolDist = doldol/D +1;
        }else{
            doldolDist = doldol/D;
        }

        long tokaDist = 0;
        if(K==0){
            if(A%B !=0){
                tokaDist = A/B +1;
            }else{
                tokaDist = A/B;
            }
        }else{
            long k =1;
            while(true){
                long sum = k*((2*B)+(k-1)*K*-1)/2;
                if(sum>=A){
                    tokaDist=k;
                    break;
                }
                if((k-1)*K>=B){
                    tokaDist = Long.MAX_VALUE;
                    break;
                }
                k++;
            }
        }
        if(tokaDist<doldolDist){
            System.out.println(tokaDist);
        }else{
            System.out.println(-1);
        }
    }
}
