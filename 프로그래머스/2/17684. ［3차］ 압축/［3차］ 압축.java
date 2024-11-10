import java.util.*;
class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        for(char i='A'; i<='Z'; i++){
            map.put(Character.toString(i),i-'A'+1);
        }
        int idx=27;
        int index=0;
        Queue<Integer> res = new LinkedList<>();
        while(index<msg.length()){
            String now = Character.toString(msg.charAt(index));
            String sub = now;
            index++;
            while(index<msg.length()){
                now += msg.charAt(index);
                if(map.get(now)==null){
                    map.put(now, idx++);
                    res.offer(map.get(sub));
                    break;
                }
                index++;
                
                sub = now;
            }
            if(index>=msg.length()){
                res.offer(map.get(now));
                break;
            }
        }
        int[] answer = new int[res.size()];
        idx=0;
        while(!res.isEmpty()){
            answer[idx++] = res.poll();
        }
            
            
        return answer;
    }
}