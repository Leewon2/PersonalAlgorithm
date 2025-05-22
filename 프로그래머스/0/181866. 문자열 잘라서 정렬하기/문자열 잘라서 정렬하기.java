import java.util.*;
class Solution {
    public String[] solution(String myString) {
        String[] answer = myString.split("x");
        List<String> list = new ArrayList<>();
        Arrays.sort(answer);
        for(int i=0; i<answer.length; i++){
            if(answer[i].equals("")) continue;
            list.add(answer[i]);
        }
        return list.toArray(new String[0]);
    }
}