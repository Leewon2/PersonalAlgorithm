class Solution {
    int answer;
    boolean[] use;
    public int solution(int[] number) {
        answer = 0;
        use = new boolean[number.length];
        perm(0,0,0,number);
        return answer;
    }
    private void perm(int now, int idx, int sum, int[] number){
        if(idx==3){
            if(sum==0) answer++;
            return;
        }
        for(int i=now; i<number.length; i++){
            if(!use[i]){
                use[i] = true;
                perm(i+1, idx+1, sum+number[i], number);
                use[i] = false;
            }
        }
    }
}