import java.util.*;
class Solution {
    int[] arr;
    boolean[] use;
    int len;
    int[][] newDice;
    int max=0;
    int[] answer;
    int calIdx;
    public int[] solution(int[][] dice) {
        newDice = new int[dice.length][6];
        for(int i=0; i<dice.length; i++){
            newDice[i] = dice[i].clone();
        }
        max = 0;
        len = dice.length/2;
        answer = new int[len];
        use = new boolean[dice.length];
        arr = new int[(int)Math.pow(6,len)];
        comb(0,0);
        for(int i=0;i<answer.length; i++){
            answer[i] += 1;
        }
        return answer;
    }
    
    // 이분탐색으로 위치 찾기
    private int binarySearch(int idx, int[] leftArr, int[] rightArr, int left, int right){
        if(left>=right) return left;
        int mid = (left+right)/2;
        if(rightArr[mid]>=leftArr[idx]){
            return binarySearch(idx, leftArr, rightArr, left, mid);
        }else{
            return binarySearch(idx, leftArr, rightArr, mid+1, right);
        }
        
    }
    
    // 선택된 것들의 합 미리 계산
    private void calculate(int[] left, int[] right){
        int[] leftArr = new int[(int)Math.pow(6,len)];
        calIdx = 0;
        calculateComb(left, 0, leftArr, 0);
        int[] rightArr = new int[(int)Math.pow(6,len)];
        calIdx = 0;
        calculateComb(right, 0, rightArr, 0);
        Arrays.sort(leftArr);
        Arrays.sort(rightArr);
        int ans = 0;
        for(int i=0; i<leftArr.length; i++){
            int cnt = binarySearch(i, leftArr, rightArr, 0, leftArr.length);
            if(cnt< 0) continue;
            ans+=cnt;
        }
        if(max<ans){
            answer = left.clone();
            max = ans;
        }
        
        ans = 0;
        for(int i=0; i<rightArr.length; i++){
            int cnt = binarySearch(i, rightArr, leftArr, 0, leftArr.length);
            if(cnt< 0) continue;
            ans+=cnt;
        }
        if(max<ans){
            answer = right.clone();
            max = ans;
        }
    }
    
    private void calculateComb(int[] l, int idx, int[] calArr, int cnt){
        if (idx == l.length) {
            calArr[calIdx++] = cnt;
            return;
        }

        int diceIdx = l[idx];
        for (int j = 0; j < 6; j++) {
            calculateComb(l, idx+1, calArr, cnt+newDice[diceIdx][j]);
        }
    }
    
    // 선택
    private void comb(int idx, int next){
        if(next>=len*2) return;
        if(idx==len){
            int[] left = new int[len];
            int lIdx=0;
            int[] right = new int[len];
            int rIdx=0;
            for(int i=0;i<len*2; i++){
                if(use[i]) left[lIdx++]=i;
                else right[rIdx++]=i;
            }
            calculate(left, right);
            return;
        }
        use[next] = true;
        comb(idx+1,next+1);
        use[next] = false;
        comb(idx, next+1);
    }
}