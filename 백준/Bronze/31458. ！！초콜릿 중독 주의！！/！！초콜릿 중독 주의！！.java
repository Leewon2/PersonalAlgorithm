
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            Queue<Character> q = new LinkedList<>();
            String str = br.readLine();
            int idx=0;
            char num='1';
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j)=='0' || str.charAt(j)=='1') {
                    idx=j;
                    num = str.charAt(j);
                }
            }
            if(str.charAt(str.length() - 1)=='!'){
                num='1';
            }
            // 짝수면 그댇로
            // 홀수면 바뀌지
            if(idx%2==0){
                sb.append(num).append("\n");
            }else{
                sb.append(num=='1' ? '0' : '1').append("\n");
            }
        }
        System.out.println(sb);
    }
}
