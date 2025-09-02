class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        // sub 갯수를 들고다니자
        int subD = 0;
        int subP = 0;
        for(int i=n-1; i>=0; i--){
           if(deliveries[i]>subD){
               int cnt = deliveries[i] - subD;
               
               int k = cnt%cap==0 ? cnt/cap : cnt/cap+1;
               answer+=((i+1)*k);
               subD = cap*k-cnt;
               subP+=(cap*k);
           }else{
               subD-=deliveries[i];
           }
           if(pickups[i]>subP){
               int cnt = pickups[i] - subP;
               
               int k = cnt%cap==0 ? cnt/cap : cnt/cap+1;
               answer+=((i+1)*k);
               subP = cap*k-cnt;
               subD+=(cap*k);
           }else{
               subP-=pickups[i];
           }
            
        
        }
        return answer*2;
    }
}