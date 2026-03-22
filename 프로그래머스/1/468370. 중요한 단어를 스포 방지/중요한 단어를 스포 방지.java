import java.util.*;
class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(message);
        for(int[] i : spoiler_ranges){
            int s = i[0];
            int e = i[1];
            for(int j=s; j<=e; j++){
                if(sb.charAt(j)!=' '){
                    sb.setCharAt(j,'*');
                }
            }
        }
        Set<String> set = new HashSet<>();
        for(String s : sb.toString().split(" ")){
            set.add(s);
        }
        for(String s : message.split(" ")){
            if(!set.contains(s)){
                set.add(s);
                answer++;
            }
        }
        return answer;
    }
}