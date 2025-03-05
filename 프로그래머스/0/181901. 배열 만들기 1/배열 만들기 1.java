class Solution {
    public int[] solution(int n, int k) {
        int[] answer = new int[n/k];
        int idx=0;
        int kk=k;
        while(kk<=n){
            answer[idx++]=kk;
            kk+=k;
        }
        return answer;
    }
}