

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack stack = new Stack();
        int sum=0;

        for (int i = 0; i < str.length(); i++) {
            char k = str.charAt(i);

            if (k == '(') {
                char nextK = str.charAt(i+1);
                if(nextK=='('){
                    stack.add('(');
                }else{
                    sum+=stack.size();
                }

            }else{
                char beforeK = str.charAt((i-1));
                if (beforeK =='(') {
                    continue;
                }else{
                    stack.pop();
                    sum+=1;
                }
            }
        }
        System.out.println(sum);
    }
}
