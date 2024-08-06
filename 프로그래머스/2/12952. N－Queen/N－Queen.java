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
    
    private static void DFS(int idx, int n){
        if(idx==n){
            answer++;
            return;
        }
        for(int i=0; i<n; i++){
            boolean check = true;
            outer : for(int d=0; d<3; d++){
                int nr = idx;
                int nc = i;
                while(nr>=0 && nc>=0 && nc<n){
                    nr += dr[d];
                    nc += dc[d];
                    if(nr<0 || nc<0 || nr>=n || nc>=n) break;
                    if(map[nr][nc]) {
                        check = false;
                        break outer;
                    }
                }
            }
            if(check){
                map[idx][i] = true;
                DFS(idx+1,n);
                map[idx][i]=false;
            }
        }
    }
}