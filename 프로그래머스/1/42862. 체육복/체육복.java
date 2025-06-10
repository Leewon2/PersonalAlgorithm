class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        boolean[] reserves = new boolean[n+1];
        boolean[] losts = new boolean[n+1];
        for(int i : lost){
            losts[i]= true;
        }
        for(int i : reserve){
            if(losts[i]) losts[i]=false;
            else reserves[i]= true;
        }
        for(int i=1; i<=n; i++){
            if(losts[i]){
                if(reserves[i-1]){
                    reserves[i-1]=false;
                    answer++;
                }else if(i+1<=n && reserves[i+1]){
                    reserves[i+1]=false;
                    answer++;
                }
            }else{
                answer++;
            }
        }
        return answer;
    }
}