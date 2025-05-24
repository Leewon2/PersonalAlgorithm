import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int k = 1;
        while(k<arr.length){
            k*=2;
        }
        int[] answer = new int[k];
        for(int i=0; i<k; i++){
            if(i>=arr.length){
                answer[i]=0;
            }else{
                answer[i]=arr[i];
            }
        }
        return answer;
    }
}