import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for(int i=0; i<ingredient.length; i++){
            if(stack.size()<3) stack.add(ingredient[i]);
            else{
                Stack<Integer> q = new Stack<>();
                if(ingredient[i]==1){
                    int idx=3;
                    for(int j=0; j<3; j++){
                        q.add(stack.peek());
                        if(idx--!=stack.pop()){
                            while(!q.isEmpty()){
                                stack.add(q.pop());
                            }
                            stack.add(ingredient[i]);
                            break;
                        }
                    }
                    if(!q.isEmpty()) answer++;
                }else{
                    stack.add(ingredient[i]);
                }
            }
        }
        return answer;
    }
}