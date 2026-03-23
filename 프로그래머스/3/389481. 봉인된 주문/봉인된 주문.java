import java.util.*;
class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";
        long[] longBan = new long[bans.length];
        // ban 당한 애들을 숫자로 표현
        for(int i=0; i<bans.length; i++){
            long sum=0;
            for(int j=0; j<bans[i].length(); j++){
                sum= sum*26 + (bans[i].charAt(j)-96);
            }
            longBan[i] = sum;
        }
        Arrays.sort(longBan);
        
        // 진짜로 찾아야 할 수
        for(long l : longBan){
            if(n>=l) n++;
            else break;
        }
        // n 값 찾기
        while(n>0){
            if(n%26==0){
                answer = 'z'+answer;
                n--;
            }else{
                answer = (char)('a'-1+n%26) + answer;
            }
            n/=26;
        }
        return answer;
    }
}