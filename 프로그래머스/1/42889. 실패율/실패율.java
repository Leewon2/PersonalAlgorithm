import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> map = new HashMap<>();
        double[][] answer = new double[N+1][2];
        for(int i=0; i<stages.length; i++){
            map.put(stages[i], map.getOrDefault(stages[i],0.0)+1);
        }
        answer[0][0] = 0.0;
        answer[0][1] = 0.0;
        double sum = stages.length;
        for(int i=1; i<=N; i++){
            if(sum==0.0){
                answer[i][0] = 0.0;
                answer[i][1] = (double) i;
                continue;
            }
            answer[i][0] = map.getOrDefault(i,0.0)/sum;
            answer[i][1] = (double)i;
            sum-=map.getOrDefault(i,0.0);
            
        }
        Arrays.sort(answer,(o1,o2)->{
            if (Double.compare(o1[0], o2[0]) == 0) {
                return Double.compare(o1[1], o2[1]);
            }
            return Double.compare(o2[0], o1[0]);
        });
 
        int[] res = new int[N];
        int idx=0;
        for(int i=0; i<=N; i++){
            if(answer[i][1]==0.0) continue;
            res[idx++]= (int) answer[i][1];
        }
        return res;
    }
}