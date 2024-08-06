class Solution {
    static int answer;
    static int[] dr={-1,-1,-1};
    static int[] dc={-1,0,1};
    static boolean[][] map;
    
    public int solution(int n) {
        map = new boolean[n][n];
        answer = 0;
        DFS(0,n);
        return answer;
    }
    private static boolean check(int r, int c, int n){
        for(int d=0; d<3; d++){
            int nr = r;
            int nc = c;
            while(nr>=0 && nc>=0 && nc<n){
                nr += dr[d];
                nc += dc[d];
                if(nr<0 || nc<0 || nc>=n) break;
                if(map[nr][nc]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private static void DFS(int idx, int n){
        if(idx==n){
            answer++;
            return;
        }
        for(int i=0; i<n; i++){
            if(check(idx,i, n)){
                map[idx][i] = true;
                DFS(idx+1,n);
                map[idx][i]=false;
            }
        }
    }
}