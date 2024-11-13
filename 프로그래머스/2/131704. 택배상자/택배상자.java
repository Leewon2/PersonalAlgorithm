import java.util.*;
class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int now = 1;
        int answer = 0;
        
        for(int i=0; i<order.length; i++){
            int k = order[i];
            if(k>now){
                for(int j=now; j<k; j++){
                    stack.add(j);
                }
                now = k+1;
                answer++;
            }else if(k==now) {
                answer++;
                now++;
            }
            else{
                if(stack.isEmpty() || stack.peek()!=k) return answer;
                stack.pop();
                answer++;
            }
            
        }
        return answer;
    }
}