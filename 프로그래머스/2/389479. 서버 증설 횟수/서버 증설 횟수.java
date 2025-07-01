import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int[] suffix = new int[48];
        int[] arr = new int[48];
        Arrays.fill(arr,1);
        int answer = 0;
        for(int i=0; i<24; i++){
            if(i!=0) {
                // suffix[i]에는 현재까지 증설된 서버의 수가 들어가야함
                suffix[i]+=suffix[i-1];
                // arr에는 현재 증설+1된 서버의 수가 들어가 있음
                arr[i]+=suffix[i];
            }
            if(arr[i]*m<=players[i]){
                int sum = players[i]/m + 1;
                
                // diff = 증설해야하는 서버
                int diff = sum-arr[i];
                answer+=diff;
                
                // suffix[i]에는 증설된 서버 갯수가 들어가야함
                suffix[i]+=diff;
                suffix[i+k]-=diff;
            }
            
        }
        return answer;
    }
}