import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        // 1개일 때부터 절반까지
        for(int i=1; i<=s.length()/2; i++){
            int len=s.length();
            String str = s.substring(0,i);
            String st = "";
            int cnt=0;
            for(int j=i; j<=s.length(); j+=i){
                if(j+i>=s.length()){
                    st = s.substring(j,s.length());
                }else{
                    st = s.substring(j,j+i);
                }
                if(st.equals(str)){
                    len-=i;
                    cnt++;
                }
                else{
                    if(cnt>=999){
                        len+=4;
                    }
                    else if(cnt>=99){
                        len+=3;
                    }
                    else if(cnt>=9){
                        len+=2;
                    }else if(cnt>0) len+=1;
                    cnt=0;
                    str = st;
                }
            }
            
            answer = Math.min(answer,len);
        }
        return answer;
        
    }
}