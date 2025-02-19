import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long kk = k;
        long dd = d;
        long answer = 0;
        for(long i=0; i<=d; i+=kk){
            long dist = (long) Math.sqrt(dd*dd-i*i);
            answer+=(dist/kk)+1;
        }
        return answer;
    }
}