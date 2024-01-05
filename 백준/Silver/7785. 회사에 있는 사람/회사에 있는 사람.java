

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();
            if(status.equals("enter")){
                map.put(name, 1);
            }else{
                map.put(name, 0);
            }
        }
        List<String> list = new ArrayList<>();
        for (String s : map.keySet()) {
            if(map.get(s)==1){
                list.add(s);
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
