import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++){
            map.put(name[i],yearning[i]);
        }
        int[] answer = new int[photo.length];
        
        for(int j=0; j<photo.length; j++){
            int sum=0;
            for(int i=0; i<photo[j].length; i++){
                if(map.get(photo[j][i])!=null) sum+=map.get(photo[j][i]);
            }
            answer[j]=sum;
        }
        return answer;
    }
}