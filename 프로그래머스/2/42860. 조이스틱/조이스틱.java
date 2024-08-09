import java.util.*;
class Solution {
    public static int solution(String name) {
        int answer = 0;
        int len = name.length()-1;
        
        for(int i=0; i<name.length(); i++){
            answer += (name.charAt(i) - 'A' > 13) ? 26 - (name.charAt(i) - 'A') : name.charAt(i) - 'A';
            
            int idx = i+1;
            while(idx < name.length() && name.charAt(idx)=='A'){
                idx++;
            }
            len = Math.min(len, i*2+name.length()-idx);
            len = Math.min(len, (name.length()-idx)*2+i);
        }
        return answer+len;
    }

}