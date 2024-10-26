import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        str1=str1.toUpperCase();
        str2=str2.toUpperCase();
        for(int i=0; i<str1.length()-1; i++){
            char l = str1.charAt(i);
            char r = str1.charAt(i+1);
            if(l-'A'<0 || l-'Z'>0 || r-'A'<0 || r-'Z'>0) continue;
            list1.add(Character.toString(l)+ Character.toString(r));
        }
        
        for(int i=0; i<str2.length()-1; i++){
            char l = str2.charAt(i);
            char r = str2.charAt(i+1);
            if(l-'A'<0 || l-'Z'>0 || r-'A'<0 || r-'Z'>0) continue;
            list2.add(Character.toString(l)+ Character.toString(r));
        }
        
        int left = 0;
        int right = list1.size()+list2.size();
        for(int i=0; i<list1.size(); i++){
            if(list2.contains(list1.get(i))){
                left++;
                list2.remove(list1.get(i));
            }
        }
        right -= left;
        if(right==0) return 65536;
        answer = left*65536/right;
        return answer;
    }
}