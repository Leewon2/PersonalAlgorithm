import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<keymap.length; i++){
            for(int j=0; j<keymap[i].length(); j++){
                map.put(keymap[i].charAt(j),Math.min(map.getOrDefault(keymap[i].charAt(j),Integer.MAX_VALUE),j+1));
            }
        }
        for(int i=0; i<targets.length; i++){
            int sum=0;
            for(int j=0; j<targets[i].length(); j++){
                if(map.get(targets[i].charAt(j))==null) {
                    answer[i] = -1; 
                    break;
                }else{
                    sum+=map.get(targets[i].charAt(j));
                }
                if(j==targets[i].length()-1) answer[i]=sum;
            }
        }
        return answer;
    }
}