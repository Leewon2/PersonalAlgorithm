import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<number.length(); i++){
            if(sb.length()==0) sb.append(number.charAt(i));
            else{
                if(k==0) sb.append(number.charAt(i));
                else{
                    int idx = sb.length()-1;
                    if(sb.charAt(idx)<number.charAt(i)){
                        while(idx>=0 && k>0){
                            if(sb.charAt(idx)>=number.charAt(i)) break;
                            k--;
                            idx--;
                        }
                        if(idx>=0){
                            answer = sb.substring(0,idx+1);
                            sb = new StringBuilder();
                            sb.append(answer).append(number.charAt(i));
                        }else{
                            sb = new StringBuilder();
                            sb.append(number.charAt(i));
                        }
                    }else{
                        sb.append(number.charAt(i));
                    }
                    
                }
            }
        }
        if(k>0) {
            answer = sb.substring(0,sb.length()-k);
            return answer;
        }
        return sb.toString();
    }
}