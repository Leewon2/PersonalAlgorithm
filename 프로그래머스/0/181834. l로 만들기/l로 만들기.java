import java.util.*;
class Solution {
    public String solution(String myString) {
        char[] c = myString.toCharArray();
        for(int i=0; i<c.length; i++){
            if(c[i]-'l'<0) c[i]='l';
        }
        return new String(c);
    }
}