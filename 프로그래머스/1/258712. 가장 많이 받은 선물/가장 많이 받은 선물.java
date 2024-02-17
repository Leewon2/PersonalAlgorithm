import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        // 선물을 주고받은 기록
        // 주고받은 수가 같거나 선물한적이 없다면, 지수를 계산
        // 주고받은 갯수 세는 map
        Map<String,Integer> map = new HashMap<>();
        // 주는 갯수 세는 map
        Map<String,Integer> sender = new HashMap<>();
        
        // 받는 갯수 세는 map
        Map<String,Integer> receiver = new HashMap<>();
        
        
        for(int i=0; i<friends.length; i++){
            for(int j=0; j<friends.length; j++){
                if(i==j) continue;
                map.put((friends[i]+" "+friends[j]),0);
            }
        }
        for(int i=0; i<friends.length; i++){
            sender.put(friends[i],0);
            receiver.put(friends[i],0);
        }
        
        for(int i=0; i<gifts.length; i++){
            String[] split = gifts[i].split(" ");
            sender.put(split[0],sender.get(split[0])+1);
            receiver.put(split[1],receiver.get(split[1])+1);
            map.put(gifts[i], map.get(gifts[i])+1);
        }
        int max=0;
        
        for(int i=0; i<friends.length; i++){
            int sum=0;
            for(int j=0; j<friends.length; j++){
                if(i==j) continue;
                String fr1 = friends[i];
                String fr2 = friends[j];
                int fr1Tofr2 = map.get(fr1+" "+fr2);
                int fr2Tofr1 = map.get(fr2+" "+fr1);
                // 준 선물이 많은 경우
                if(fr1Tofr2>fr2Tofr1){
                    sum++;
                }
                // 주고받은 선물이 같은 경우
                else if(fr1Tofr2==fr2Tofr1){
                    int fr1Point = sender.get(fr1)-receiver.get(fr1);
                    int fr2Point = sender.get(fr2)-receiver.get(fr2);
                    if(fr1Point>fr2Point) sum++;
                }
            }
            max = Math.max(max,sum);
        }
        
        return max;
    }

}