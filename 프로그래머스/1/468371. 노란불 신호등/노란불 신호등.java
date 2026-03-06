import java.util.*;
class Solution {
    public int solution(int[][] signals) {
        int answer = 0;
        int[] arr = new int[50000000];
        for(int i=0; i<signals.length; i++){
            int s = signals[i][0]+1;
            int sum = signals[i][0]+signals[i][1]+signals[i][2];
            int a = 0;
            while(a<500000){
                int ss = s;
                for(int k=ss; k<s+signals[i][1]; k++){
                    if(k>=50000000) break;
                    arr[k] +=1;
                }
                a++;
                s+=sum;
            }
        }
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]==signals.length) return i;
        }
        return -1;
    }
    
    private class Signal{
        int num;
        int cnt;
        public Signal(int num, int cnt){
            this.num=num;
            this.cnt=cnt;
        }
    }
}