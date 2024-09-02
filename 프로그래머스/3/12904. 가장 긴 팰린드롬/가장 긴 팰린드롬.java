import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        for(int i=1; i<s.length()-1; i++){
            char standard = s.charAt(i);
            int idx=1;
            int len=1;
            while(true){
                if(i-idx<0 || i+idx>=s.length()) break;
                if(s.charAt(i-idx)==s.charAt(i+idx)){
                    len+=2;
                }else 
                    break;
                idx++;
            }
            answer= Math.max(answer,len);
        }
        for(int i=0; i<s.length()-1; i++){
            char standard = s.charAt(i);
            int left=i;
            int right=i+1;
            int len=0;
            while(true){
                if(left<0 || right>=s.length()) break;
                if(s.charAt(left)==s.charAt(right)){
                    len+=2;
                    left--;
                    right++;
                }else
                    break;
            }
            answer= Math.max(answer,len);
        }
        

        return answer;
    }
}