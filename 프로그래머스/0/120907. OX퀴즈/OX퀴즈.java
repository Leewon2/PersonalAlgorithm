import java.util.*;
class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i=0; i<quiz.length; i++){
            String[] s = quiz[i].split(" ");
            answer[i] = calculate(s[0],s[1],s[2],s[4]);
        }
        return answer;
    }
    private String calculate(String x,String sign, String y, String res){
        int xx = Integer.parseInt(x);
        int yy = Integer.parseInt(y);
        int result = Integer.parseInt(res);
        if(sign.equals("+")){
            if(xx+yy==result) return "O";
            return "X";
        }else{
            if(xx-yy==result) return "O";
            return "X";
        }
    }
}