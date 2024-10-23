class Solution {
    boolean[] use;
    int answer;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        use = new boolean[dungeons.length];
        dfs(k,dungeons,0);
        return answer;
    }
    
    private void dfs(int k, int[][] dungeons, int cnt){
        answer = Math.max(answer, cnt);
        for(int i=0; i<dungeons.length; i++){
            if(use[i]) continue;
            if(k>=dungeons[i][0]){
                use[i]=true;
                dfs(k-dungeons[i][1],dungeons, cnt+1);
                use[i]=false;
            }
        
        }
    }
}