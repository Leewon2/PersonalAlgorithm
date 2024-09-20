import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        boolean[] use = new boolean[people.length];
        int index=0;
        for(int i=people.length-1; i>=0; i--){
            if(use[i]) break;
            if(people[index]+people[i]<=limit){
                use[index]=true;
                index++;
                answer++;
                
            }else{
                answer++;
            }
            use[i] = true;
        }
        return answer;
    }
}