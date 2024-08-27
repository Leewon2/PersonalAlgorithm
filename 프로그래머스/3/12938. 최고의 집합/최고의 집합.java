import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int[] cant = {-1};
        int k = 1;
        if(s/n<=0) return cant;
        for(int i=0; i<n; i++){
            answer[i] = s/n;
        }
        for(int i=n-1; i>(n-1)-s%n; i--){
            answer[i] += 1;
        }
        // Arrays.sort(answer);
        return answer;
    }
}