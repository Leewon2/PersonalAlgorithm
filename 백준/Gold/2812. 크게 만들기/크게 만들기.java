
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String num = br.readLine();

        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < num.length(); i++) {
            int x = Character.getNumericValue(num.charAt(i));

            if(!stack.isEmpty()){
                while(!stack.isEmpty() && K!=0){

                    if(stack.peek()<x){
                        stack.pop();
                        K--;
                    }else{
                        break;
                    }
                }
            }
            stack.push(x);
        }

        while (K != 0) {
            stack.pop();
            K--;
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {

            sb.append(stack.pollLast());

        }
        System.out.println(sb);
    }
}
