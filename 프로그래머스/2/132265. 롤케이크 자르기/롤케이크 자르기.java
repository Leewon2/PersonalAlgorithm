import java.util.*;
class Solution {
    public int solution(int[] topping) {
        // 토핑의 갯수를 세고, set을 이용해 갯수를 센다. 정확히 절반이면 answer에 +1 하면 될듯
        
        int answer = 0;
        Set<Integer> toppingCnt = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<topping.length; i++){
            if(map.get(topping[i])==null){
                map.put(topping[i],1);
            }else{
                map.put(topping[i],map.get(topping[i])+1);    
            }
        }
        for(int i=0; i<topping.length; i++){
            toppingCnt.add(topping[i]);
            if(map.get(topping[i])==1){
                map.remove(topping[i]);
            }else{
                map.put(topping[i],map.get(topping[i])-1);
            }
            if(toppingCnt.size()==map.size()) answer++;
        }
        return answer;
    }
}