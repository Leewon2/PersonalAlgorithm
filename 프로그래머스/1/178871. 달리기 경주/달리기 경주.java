import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String,Integer> map = new HashMap<>();
        String[] answer = new String[players.length];
        for(int i=0; i<players.length; i++){
            map.put(players[i],i);
            answer[i] = players[i];
        }
        
        for(String s: callings){
            int num = map.get(s);
            String name = answer[num-1];
            answer[num-1] = answer[num];
            answer[num]=name;
            map.put(answer[num-1],num-1);
            map.put(answer[num],num);
        }

        return answer;
    }

}