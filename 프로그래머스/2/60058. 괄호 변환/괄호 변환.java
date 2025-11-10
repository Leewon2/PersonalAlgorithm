import java.util.*;
class Solution {
    public String solution(String p) {
        if(checkCorrectString(p)) return p;
        return step2(p);
    }
    // 올바른 괄호 문자열인가?
    private boolean checkCorrectString(String s){
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(') stack.add(1);
            else{
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    
    private String step2(String s){
        if(s.equals("")) return "";
        int left=0;
        int right=0;
        Stack<Integer> stack = new Stack<>();
        String u=""; String v="";
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(') left++;
            else right++;
            // 갯수가 같아지는 시점
            if(left==right){
                u = s.substring(0,i+1);
                v  = s.substring(i+1,s.length());
                break;
            }
        }
        if(checkCorrectString(u)){
            return u+step2(v);
        }
        return step4(u,v);
    }
    private String step4(String u, String v){
        String str = "(";
        str+=step2(v);
        str+=")";
        String s = u.length()==2 ? "" : u.substring(1,u.length()-1);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                str+=")";
            }else{
                str+="(";
            }
        }
        return str;
    }
    
}