import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        boolean[] use = new boolean[100001];
        Arrays.fill(answer,-1);
        int idx=0;
        for(int i=0; i<arr.length; i++){
            if(idx>=k) break;
            if(!use[arr[i]]) {
                answer[idx++]=arr[i];
                use[arr[i]]=true;
            }
        }
        return answer;
    }
}