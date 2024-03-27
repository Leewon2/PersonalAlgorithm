import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        boolean[] visited = new boolean[str.length()];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(visited[i]) continue;
            if(str.charAt(i)=='.'){
                sb.append(".");
                continue;
            }
            int a = i+4;
            int b = i+2;
            boolean useA = true;
            for (int j = i; j < a; j++) {
                if(j>=str.length() || str.charAt(j)=='.'){
                    useA = false;
                    break;
                }
            }
            if(useA){
                for(int j=i; j<a; j++){
                    visited[j]=true;
                }
                sb.append("AAAA");
            }else{
                boolean useB = true;
                for (int j = i; j < b; j++) {
                    if(j>=str.length() || str.charAt(j)=='.'){
                        useB = false;
                        break;
                    }
                }
                if(useB){
                    for(int j=i; j<b; j++){
                        visited[j]=true;
                    }
                    sb.append("BB");
                }else{
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }
        System.out.println(sb);
    }



}
