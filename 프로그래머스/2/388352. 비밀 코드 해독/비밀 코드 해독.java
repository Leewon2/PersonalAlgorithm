class Solution {
    int[] sub;
    int answer;
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        sub = new int[5];
        comb(0,1,n,q,ans);
        return answer;
    }
    
    private void comb(int idx, int num, int n, int[][] q, int[] ans){
        if(idx==5){
            if(calculate(q,ans)) answer++;
            return;
        }
        for(int i=num; i<=n; i++){
            sub[idx] = i;
            comb(idx+1, i+1, n, q, ans);
        }
    }
    
    private boolean calculate(int[][] q, int[] ans){
        int[] subCnt = new int[31];
        for(int s : sub){
            subCnt[s]++;
        }
        for(int i=0; i<q.length; i++){
            int cnt = 0;
            // q를 순회하면서 같은게 몇개 있는지 판별
            for(int j=0; j<q[i].length; j++){
                if(subCnt[q[i][j]]==1) cnt++;
            }
            // 같은게 3개다. 근데 ans는 2개다? 같은게 2개다. 근데 ans는 3개다? 다 말이 안된다.
            if(cnt != ans[i]) return false;
        }
        return true;
    }
}