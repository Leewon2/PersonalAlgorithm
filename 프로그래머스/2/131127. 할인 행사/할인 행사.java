import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for(int i=0; i<discount.length-want.length; i++){
            int[] num = number.clone();
            for(int j=i; j<i+10; j++){
                if(j>= discount.length) break;
                for(int k=0; k<want.length; k++){
                    if(want[k].equals(discount[j]) && num[k]>0){
                        num[k]--;
                        break;
                    }    
                }
            }
            boolean check = true;
            for(int k=0; k<want.length; k++){
                if(num[k]!=0) check=false;
            }
            if(check) answer++;
        }
        return answer;
    }
}