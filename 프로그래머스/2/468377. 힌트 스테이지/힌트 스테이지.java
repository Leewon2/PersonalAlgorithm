import java.util.*;
class Solution {
    boolean[] use;
    int[][] hints;
    int[][] costs;
    int len;
    int min;
    public int solution(int[][] cost, int[][] hint) {
        int answer = 0;
        hints = new int[hint.length][hint[0].length];
        costs = new int[cost.length][cost[0].length];
        len = hint.length;
        min = Integer.MAX_VALUE;
        for(int i = 0; i < hint.length; i++){
            hints[i] = hint[i].clone();
        }
        for(int i = 0; i < cost.length; i++){
            costs[i] = cost[i].clone();
        }
        use = new boolean[hint.length];
        perm(0);
        return min;
    }
    
    // 부분집합으로 hint를 사니 마니 해보자
    private void perm(int idx){
        if(idx==len){
            calculate();
            return;
        }
        use[idx] = true;
        perm(idx+1);
        use[idx] = false;
        perm(idx+1);
        
    }
    private void calculate(){
        int[] count = new int[costs.length+1];
        int total = 0;
        for(int i=0; i<use.length; i++){
            if(use[i]){
                total+=hints[i][0];
                for(int j=1; j<hints[i].length; j++){
                    count[hints[i][j]]++;
                }
            }
        }
        for(int i=0; i<costs.length; i++){
            int ticket = Math.min(costs[0].length-1,count[i+1]);
            total+=costs[i][ticket];
        }
        min = Math.min(total,min);
    }
}