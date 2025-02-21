import java.util.*;
class Solution {
    public int solution(int[][] scores) {

        
        int x = scores[0][0];
        int y = scores[0][1];
        Arrays.sort(scores,(o1,o2)->{
            if(o1[0]==o2[0]) return o1[1]-o2[1];
            return o2[0]-o1[0];
        });
        int answer = 1;
        int max = 0;
        
        for(int[] score : scores){
            if(max<=score[1]){
                max = score[1];
                if(score[0]+score[1]>x+y) answer++;
            }else{
                if(score[0]==x && score[1]==y) return -1;
            }
        }

        return answer;
    }

}
