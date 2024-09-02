import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        // if(gems.length==1) return new int[]{1,1};
        Set<String> set = new HashSet<>();
        // 몇개나 들어왔는지 확인
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<gems.length; i++){
            if(!set.contains(gems[i])){
                set.add(gems[i]);
            }
            map.put(gems[i],0);
        }
        int size = set.size();
        set.clear();
        
        int right = 0;
        int left = 0;
        int resRight=right;
        int resLeft=left;
        
        int len=1;
        int beforeLen=Integer.MAX_VALUE;
        set.add(gems[left]);
        map.put(gems[left],map.get(gems[left])+1);
        
        while(left<gems.length && right<gems.length){
            if(set.size()==size){
                while(left<right){
                    if(map.get(gems[left])>1){
                        map.put(gems[left],map.get(gems[left])-1);
                        left++;
                        len--;
                        
                    }else{
                        break;
                    }
                }
                if(len<beforeLen){
                    resRight = right;
                    resLeft = left;
                    beforeLen=len;
                }
            }
            if(gems[left].equals(gems[right])){
                if(left==right) {
                    right++;
                    len++;
                    if(right<gems.length){
                        set.add(gems[right]);
                        map.put(gems[right],map.get(gems[right])+1);
                    }
                }
                else {
                    map.put(gems[left],map.get(gems[left])-1);
                    left++;
                    len--;
                }
            }
            else{
                right++;
                len++;
                if(right<gems.length){
                    set.add(gems[right]);
                    map.put(gems[right],map.get(gems[right])+1);
                }
            }
        }
        int[] answer = {resLeft+1, resRight+1};
        return answer;
    }
}