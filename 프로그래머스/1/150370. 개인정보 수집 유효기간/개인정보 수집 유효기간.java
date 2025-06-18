import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        String[] date = today.split("\\.");
        int day = (Integer.parseInt(date[0])*28*12)+(Integer.parseInt(date[1])*28)+Integer.parseInt(date[2]);
        for(int i=0; i<terms.length; i++){
            String[] t = terms[i].split(" ");
            map.put(t[0],Integer.parseInt(t[1]));
        }
        for(int i=0; i<privacies.length; i++){
            String[] privacie = privacies[i].split(" ");
            int alpha = map.get(privacie[1]);
            String[] d = privacie[0].split("\\.");
            int compare = (Integer.parseInt(d[0])*28*12)+((Integer.parseInt(d[1])+alpha)*28)+Integer.parseInt(d[2]);
            if(compare<=day) list.add(i+1);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}