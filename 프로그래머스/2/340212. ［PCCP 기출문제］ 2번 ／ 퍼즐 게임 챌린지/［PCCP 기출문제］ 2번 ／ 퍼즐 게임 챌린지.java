class Solution {
    int min;
    public int solution(int[] diffs, int[] times, long limit) {
        min = Integer.MAX_VALUE;
        binarySearch(0,Integer.MAX_VALUE, diffs, times, limit);
        if(min==0) return 1;
        return min;
    }
    
    private void binarySearch(int left, int right, int[] diffs, int[] times, long limit){
        if(left>right) return;
        int mid = (left+right)/2;
        boolean check = calculate(mid, diffs, times, limit);
        if(check){
            binarySearch(left,mid-1, diffs, times, limit);
        }else{
            binarySearch(mid+1,right, diffs, times, limit);
        }
    }
    
    private boolean calculate(int mid, int[] diffs, int[] times, long limit){
        long sum=times[0];
        int prev = 0;
        for(int i=1; i<diffs.length;i++){
            if(mid>=diffs[i]){
                sum+= (long) times[i];
            }else{
                sum+= (long) times[i]+(((long) times[prev]+times[i]) *(diffs[i]-mid));
            }
            prev=i;
        }
        if(sum<=limit){
            min = Math.min(min, mid);
            return true;
        }
        return false;
    }
    
}