import java.util.*;
class Solution {
    int max;
    int[] answer;
    public int[] solution(int n, int[] info) {
        max=0;
        int[] compare = new int[11];
        dfs(0,n,info,compare);
        if(max==0) return new int[]{-1};
        return answer;
    }
    
    private void dfs(int idx, int remain, int[] info, int[] compare){
        if(remain<0) return;
        if(idx==11 || remain<=0){
            if(idx==11) {
                compare[10]+=remain;
            }else{
                
            }
            int lionScore = calculate(compare,info);
            if(lionScore>0){
                if(lionScore>max){
                    max = lionScore;
                    answer = compare.clone();
                } else if(lionScore==max){
                    if (answer == null) {
                        answer = compare.clone();
                    } else {
                        for (int i = 10; i >= 0; i--) {
                            if (compare[i] > answer[i]) {
                                answer = compare.clone();
                                break;
                            }else if(compare[i] < answer[i]) break;
                        }
                    }
                }
            }
            
            compare[10]-=remain;
            return;
        }
        if(info[idx]>=remain){
            dfs(idx+1, remain, info, compare);
        }else{
            compare[idx] = info[idx]+1;
            dfs(idx+1, remain-compare[idx], info, compare);
            compare[idx] = 0;
            dfs(idx+1, remain, info, compare);
        }
    }
    private int calculate(int[] arr1, int[] arr2){
        int cnt=0;
        for(int i=0; i<11; i++){
            if(arr1[i]==0 && arr2[i]==0) continue;
            if(arr1[i]>arr2[i])
                cnt+=10-i;
            else cnt-=10-i;
        }
        return cnt;
    }
    
}