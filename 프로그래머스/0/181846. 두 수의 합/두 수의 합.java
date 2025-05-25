import java.util.*;
class Solution {
    public String solution(String a, String b) {
        String answer="";
        List<Integer> list = new ArrayList<>();
        int max = Math.max(a.length(), b.length());
        int x=0;
        int y=0;
        int next=0;
        int aIdx = a.length()-1;
        int bIdx= b.length()-1;
        for(int i=max-1; i>=0; i--){
            if(aIdx<0) x=0;
            else x = Character.getNumericValue(a.charAt(aIdx--));
            if(bIdx<0) y=0;
            else y = Character.getNumericValue(b.charAt(bIdx--));
            int sum = x+y+next;
            next=0;
            if(sum>=10){
                next=1;
                sum-=10;
            }
            list.add(sum);
        }
        if(next!=0) list.add(1);
        for(int i=list.size()-1; i>=0; i--){
            answer+=list.get(i);
        }
        return answer;
    }
}