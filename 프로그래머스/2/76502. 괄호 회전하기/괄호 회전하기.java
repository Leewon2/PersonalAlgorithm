import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('[',1);
        map.put(']',2);
        map.put('(',10);
        map.put(')',11);
        map.put('{',100);
        map.put('}',101);
        for(int i=0; i<s.length(); i++){
            Stack<Character> stack = new Stack<>();
            for(int j=i; j<i+s.length(); j++){
                Character c = s.charAt(j%s.length());
                if(stack.isEmpty()) stack.add(c);
                else{
                    if(map.get(c)-map.get(stack.peek())==1) stack.pop();
                    else stack.add(c);
                }
            }
            if(stack.isEmpty()) answer++;
        }
        return answer;
    }
}