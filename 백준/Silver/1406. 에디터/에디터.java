

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Deque<Character> stack1 = new ArrayDeque<Character>();
        Deque<Character> stack2 = new ArrayDeque<Character>();
        for (int i = 0; i < str.length(); i++) {
            stack1.offerLast(str.charAt(i));
        }

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char k = st.nextToken().charAt(0);
            if(k=='P'){
                char x = st.nextToken().charAt(0);
                stack1.offerLast(x);


            }else{
                if (k=='L' && !stack1.isEmpty()) {
                    stack2.offerLast(stack1.pollLast());
                }else if(k=='D'&& !stack2.isEmpty()){
                    stack1.offerLast(stack2.pollLast());
                }else if(k=='B' && !stack1.isEmpty()){
                    stack1.pollLast();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack1.isEmpty()) {
            sb.append(stack1.pollFirst());
        }
        while (!stack2.isEmpty()) {
            sb.append(stack2.pollLast());
        }
        System.out.println(sb);
    }

}
