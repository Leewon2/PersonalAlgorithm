import java.util.*;
class Solution {
    Map<String,List<Integer>> map;
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();
        for(int i=0; i<info.length; i++){
            String[] str = info[i].split(" ");
            makeMap(0, "", str);
        }
        
        for(String s : map.keySet()){
            Collections.sort(map.get(s));
        }
        
        for(int i=0; i<query.length; i++){
            String[] str = query[i].replaceAll("and ","").split(" ");
            String s = "";
            int score = Integer.parseInt(str[4]);
            for(int j=0; j<str.length-1; j++){
                if(str[j].equals("-")) continue;
                s+=str[j];
            }
            answer[i] = map.get(s) == null ? 0 : search(score,map.get(s));
        }
        
        return answer;
    }
    
    private int search(int k, List<Integer> list){
        if(list.get(list.size()-1)<k) return 0;
        int s = 0; int e = list.size()-1;
        while(s<=e){
            int mid = (s+e)/2;
            if(list.get(mid)<k) s = mid+1;
            else e = mid-1;
        }
        return list.size()-s;
        
    }
    
    private void makeMap(int idx, String s, String[] str){
        if(idx==4){
            List<Integer> list = map.getOrDefault(s,new ArrayList<>());
            list.add(Integer.parseInt(str[4]));
            map.put(s, list);
            return;
        }
        
        makeMap(idx+1, s+str[idx], str);
        makeMap(idx+1, s, str);
        
    }
}