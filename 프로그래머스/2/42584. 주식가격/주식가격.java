import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int[][] pricesAndIdx = new int[prices.length][2];
        for(int i=0; i<prices.length; i++){
            pricesAndIdx[i][0] = prices[i];
            pricesAndIdx[i][1] = i;
        }
        Stack<int[]> stack = new Stack<>();
        for(int i=0; i<pricesAndIdx.length; i++){
            while(!stack.isEmpty()){
                int k = stack.peek()[0];
                if(k>pricesAndIdx[i][0]) {
                    answer[stack.peek()[1]] = i - stack.peek()[1];
                    stack.pop();
                }
                else break;
                
            }
            
            stack.add(new int[]{pricesAndIdx[i][0],pricesAndIdx[i][1]});
        }
        while(!stack.isEmpty()){
            answer[stack.peek()[1]] = prices.length - stack.peek()[1]-1;
            stack.pop();
        }
        return answer;
    }
}