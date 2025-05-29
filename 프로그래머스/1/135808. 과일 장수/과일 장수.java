import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int answer = 0;
        int[] apple = new int[m];
        int idx=0;
        for(int i=score.length-1; i>=0; i--){
            apple[idx++]=score[i];
            if(idx>=m) {
                idx=0;
                answer+=apple[m-1]*m;
            }
        }
        return answer;
    }
}