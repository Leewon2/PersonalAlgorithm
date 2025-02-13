class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] paint = new boolean[n+1];
        for(int s : section){
            paint[s]=true;
        }
        int idx=1;
        while(idx<=n){
            if(paint[idx]) {
                idx+=m;
                answer++;
            }
            else idx++;
        }
        return answer;
    }
}