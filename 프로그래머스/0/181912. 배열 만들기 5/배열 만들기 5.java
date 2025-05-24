import java.util.*;
class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<intStrs.length; i++){
            String str = intStrs[i].substring(s,l+s);
            if(Integer.parseInt(str)>k) list.add(Integer.parseInt(str));
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}