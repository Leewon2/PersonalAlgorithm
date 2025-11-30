import java.util.*;
class Solution {
    public int solution(int n, int[] cores) {
        if(n<=cores.length) return n;
        long t = binarySearch(n,cores);
        long cnt = cores.length;
        for(int i : cores){
            cnt+=(t-1)/i;
        }
        for(int i=0; i<cores.length; i++){
            if(t%cores[i]==0) cnt++;
            if(cnt==n) return i+1;
        }
        
        return 0;
    }
    
    private long binarySearch(int n, int[] cores){
        long left = 1L;
        long right = 2000000000000L;
        while(left<right){
            long cnt = cores.length;
            long mid = (left+right)/2;
            for(int i : cores){
                cnt += (mid/i);
            }
            if(cnt>=n) right=mid;
            else left = mid+1;
        }
        return left;
    }

}