
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double sum=0;
        int cnt = 0;
        String[] arr = {"A+","A0","B+","B0","C+","C0","D+","D0"};
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            if (grade.equals("P")) {
                continue;
            }
            for(int j=0; j<8; j++){
                if (arr[j].equals(grade)) {
                    sum += (((9-j) * 0.5) * score);
                    cnt+= (int) score;
                }
            }
                        if (grade.equals("F")) {
                cnt+=(int)score;
            }
        }
        System.out.printf("%.5f",sum/cnt);
    }
}
