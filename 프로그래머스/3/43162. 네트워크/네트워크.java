import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] use = new boolean[computers.length];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<use.length; i++){
            if(!use[i]){
                answer++;
                q.offer(i);
                while(!q.isEmpty()){
                    int poll = q.poll();
                    use[poll]=true;
                    for(int j=0;j<use.length; j++){
                        if(poll==j || computers[poll][j]==0 || use[j]) continue;
                        q.offer(j);
                    }
                }
            }
        }
        
        return answer;
    }
}