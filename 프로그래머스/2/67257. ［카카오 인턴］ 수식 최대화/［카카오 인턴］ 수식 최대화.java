import java.util.*;
class Solution {
    final char[] ch = new char[]{'+','-','*'};
    boolean[] use = new boolean[3];
    long answer;
    
    public long solution(String expression) {
        answer = 0;
        perm(0,new char[3],expression);

        return answer;
    }
    
    private long makeMax(char[] c, String expression){
        Deque<String> dq1 = new ArrayDeque<>();
        Deque<String> dq2 = new ArrayDeque<>();
        String str="";
        for(int i=0; i<expression.length(); i++){
            if(expression.charAt(i)>='0'&& expression.charAt(i)<='9'){
                str+=expression.charAt(i);
            }else{
                dq1.addFirst(str);
                dq1.addFirst(String.valueOf(expression.charAt(i)));
                str="";
            }
        }
        dq1.addFirst(str);
        for(int i=0; i<3; i++){
            while(!dq1.isEmpty()){
                if(dq1.peekLast().equals(String.valueOf(c[i]))){
                    String check = dq1.removeLast();
                    dq2.addFirst(calculate(c[i],dq2.removeFirst(),dq1.removeLast()));
                }else{
                    dq2.addFirst(dq1.removeLast());
                }
            }
            while(!dq2.isEmpty()){
                dq1.addFirst(dq2.removeLast());
            }
        }

        
        return Long.parseLong(dq1.peek());
        
    }
    
    private String calculate(char c, String x, String y){
        long xx = Long.parseLong(x);
        long yy = Long.parseLong(y);
        long result=0;
        if(c=='+'){
            result = xx+yy;
        }else if(c=='-'){
            result = xx-yy;
        }else{
            result = xx*yy;
        }
        return String.valueOf(result);
    }
    
    private void perm(int idx, char[] c, String expression){
        if(idx==3){
            answer = Math.max(answer,Math.abs(makeMax(c,expression)));
            return;
        }
        for(int i=0; i<3; i++){
            if(use[i]) continue;
            use[i]=true;
            c[idx]=ch[i];
            perm(idx+1,c,expression);
            use[i]=false;
        }
    }
}