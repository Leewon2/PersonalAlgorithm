import java.util.*;
class Solution {
    int[] divisor;
    public int solution(int number, int limit, int power) {
        divisor=new int[number+1];
        Arrays.fill(divisor,1);
        for(int i=2; i<=number; i++){
            int k = i;
            while(k<=number){
                divisor[k]++;
                k+=i;
                
            }
        }
        int answer = 0;
        for(int i=1; i<=number; i++){
            if(divisor[i]>limit) answer+=power;
            else answer+=divisor[i];
        }
        return answer;
    }
}