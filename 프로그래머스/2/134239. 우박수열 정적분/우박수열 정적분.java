import java.util.*;
class Solution {
    double[] suffix;
    public double[] solution(int k, int[][] ranges) {
        Queue<Integer> q = collatz(k);
        suffix = new double[q.size()];
        int sub=q.poll();
        for(int  i=1; i<suffix.length; i++){
            int poll = q.poll();
            suffix[i] = suffix[i-1]+((double)(sub+poll)/2);
            sub =poll;
        }
        double[] answer = new double[ranges.length];
        for(int i=0; i<ranges.length; i++){
            int start = ranges[i][0];
            int end = suffix.length+ranges[i][1]-1;
            if(start==end){
                answer[i] = 0;
            }else if(start>end){
                answer[i]=-1;
            }else{
                answer[i] = suffix[end]-suffix[start];
            }
            
        }
        return answer;
    }
    
    private Queue<Integer> collatz(int k){
        Queue<Integer> q = new LinkedList<>();
        int idx = k;
        q.offer(idx);
        while(idx!=1){
            if(idx%2==0) idx/=2;
            else idx=idx*3+1;
            q.offer(idx);
        }
        return q;
    }
}