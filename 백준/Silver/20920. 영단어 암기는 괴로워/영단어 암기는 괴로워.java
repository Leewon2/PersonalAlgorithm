import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        int count=0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.length() < M) continue;
            if(map.get(str)==null){
                map.put(str, 1);
                count++;
            }else{
                map.put(str, map.get(str) + 1);
            }
        }
        Node[] arr = new Node[count];
        int idx=0;
        for(Map.Entry<String, Integer> e : map.entrySet()){
            String str = e.getKey();
            int cnt = e.getValue();
            int length = str.length();
            arr[idx++] = new Node(str, cnt, length);
        }
        Arrays.sort(arr, (o1, o2) -> {
            if(o1.cnt!=o2.cnt){
                return o2.cnt - o1.cnt;
            } else if (o1.length != o2.length) {
                return o2.length - o1.length;
            }
            return o1.word.compareTo(o2.word);
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(arr[i].word).append("\n");

        }
        System.out.println(sb);
    }

    private static class Node {
        String word;
        int cnt;
        int length;

        public Node(String word, int cnt, int length) {
            this.word = word;
            this.cnt = cnt;
            this.length = length;
        }
    }
}
