import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String s = br.readLine();
        boolean[] visited = new boolean[str.length()];
        int cnt=0;
//        System.out.println(str.substring(0,4));
        for (int i = 0; i < str.length(); i++) {
            if(!visited[i]){
//                System.out.println(1);
                if(i+s.length()<=str.length() && str.substring(i,i+s.length()).equals(s)){
                    for (int j = i; j < i+s.length(); j++) {
                        visited[j]=true;
                    }
                        cnt++;
                }
            }
        }
        System.out.println(cnt);
    }



}


//
/*
 * 2143
 * 3412
 * */
