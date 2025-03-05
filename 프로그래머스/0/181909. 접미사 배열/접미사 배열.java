import java.util.*;
class Solution {
    public String[] solution(String my_string) {
        int len = my_string.length();
        String[] answer = new String[len];
        String s ="";
        for(int i=len-1; i>=0;i--){
            s=my_string.charAt(i)+s;
            answer[i]=s;
        }
        Arrays.sort(answer);
        return answer;
    }
}