import java.util.*;
class Solution {
    public int[] solution(int e, int[] starts) {
        
        
        int[] mineralwater = new int[e+1];
        int[] answer =new int[starts.length];
        int max = 0;
        int num = 0;
        int[] number = new int[e+1];
        for(int i=2; i<=e; i++){
            for(int j=1; j<=e/i; j++){
                number[i*j]++;
            }
        }
        for(int i=e; i>=1; i--){
            int cnt=number[i];
            if(max<=cnt){
                num = i;
                max = cnt;
            }
        
            mineralwater[i] = num;
        }
                
            
        
        
        for(int i=0; i<starts.length; i++){
            answer[i] = mineralwater[starts[i]];
        }
        
        return answer;
    }
}