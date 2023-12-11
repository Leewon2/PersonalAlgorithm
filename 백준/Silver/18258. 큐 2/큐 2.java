

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("push")){
                int number = Integer.parseInt(st.nextToken());
                dq.offer(number);
            } else if (str.equals("front")) {
                if(dq.isEmpty()) sb.append(-1).append("\n");
                else sb.append(dq.peekFirst()).append("\n");
            }
            else if (str.equals("back")) {
                if(dq.isEmpty()) sb.append(-1).append("\n");
                else sb.append(dq.peekLast()).append("\n");
            }
            else if (str.equals("empty")) {
                if(dq.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            else if (str.equals("size")) {
                sb.append(dq.size()).append("\n");
            }
            else if (str.equals("pop")) {
                if(dq.isEmpty()) sb.append(-1).append("\n");
                else sb.append(dq.pollFirst()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
