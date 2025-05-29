import java.util.*;
class Solution {
    final int[] first = {1,2,3,4,5};
    final int[] second = {2,1,2,3,2,4,2,5};
    final int[] third = {3,3,1,1,2,2,4,4,5,5};
    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        int[] res = new int[3];
        int a=0, b=0, c=0;
        for(int i=0; i<answers.length; i++){
            if(answers[i]==first[i%5]) res[0]++;
            if(answers[i]==second[i%8]) res[1]++;
            if(answers[i]==third[i%10]) res[2]++;
        }
        int max =0;
        for(int i=0; i<3; i++) max = Math.max(max,res[i]);
        for(int i=0; i<3; i++){
            if(res[i]==max) list.add(i+1);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
        
    }
}