class Solution {
    int max;
    int[] dr = {1,0,-1,0};
    int[] dc = {0,1,0,-1};
    int r;
    int c;
    boolean[][] redVisited;
    boolean[][] blueVisited;
    int[][] arr;
    public int solution(int[][] maze) {
        int answer = 0;
        max = Integer.MAX_VALUE;
        r = maze.length;
        c = maze[0].length;
        redVisited = new boolean[r][c];
        blueVisited = new boolean[r][c];
        arr = new int[r][c];
        int redStartR=0;
        int redStartC=0;
        int blueStartR=0;
        int blueStartC=0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(maze[i][j]==1){
                    redStartR=i;
                    redStartC=j;
                }else if(maze[i][j]==2){
                    blueStartR=i;
                    blueStartC=j;
                }else{
                    arr[i][j] = maze[i][j];
                }
            }
        }
        redVisited[redStartR][redStartC] = true;
        blueVisited[blueStartR][blueStartC] = true;
        dfs(redStartR,redStartC,blueStartR,blueStartC,0);
        return max==Integer.MAX_VALUE ? 0 : max;
    }
    
    // 빨 - 파, 파 - 빨 둘 다 확인
    private void dfs(int redR, int redC, int blueR, int blueC, int cnt){
        if(arr[redR][redC]==3 && arr[blueR][blueC]==4){
            max = Math.min(max, cnt);
            return;
        }
        
        if(arr[redR][redC]==3){
            for(int d=0; d<4; d++){
                int nr = blueR+dr[d];
                int nc = blueC+dc[d];
                if(nr<0 || nr>=r || nc<0 || nc>=c || arr[nr][nc]==5 || blueVisited[nr][nc]) continue;
                if(nr==redR && nc==redC) continue;
                blueVisited[nr][nc]=true;
                dfs(redR,redC,nr, nc, cnt+1);
                blueVisited[nr][nc]=false;
            }
        }else if(arr[blueR][blueC]==4){
            for(int d=0; d<4; d++){
                int nr = redR+dr[d];
                int nc = redC+dc[d];
                if(nr<0 || nr>=r || nc<0 || nc>=c || arr[nr][nc]==5 || redVisited[nr][nc]) continue;
                if(nr==blueR && nc==blueC) continue;
                redVisited[nr][nc]=true;
                dfs(nr,nc,blueR, blueC, cnt+1);
                redVisited[nr][nc]=false;
            }
        }
        
        else{
            for(int d=0; d<4; d++){
                int nr = redR+dr[d];
                int nc = redC+dc[d];
                if(nr<0 || nr>=r || nc<0 || nc>=c || arr[nr][nc]==5 || redVisited[nr][nc]) continue;
                if(nr==blueR && nc==blueC) continue;
                for(int dd=0 ;dd<4; dd++){
                    int bnr = blueR+dr[dd];
                    int bnc = blueC+dc[dd];
                    if(bnr<0 || bnr>=r || bnc<0 || bnc>=c || arr[bnr][bnc]==5 || blueVisited[bnr][bnc]) continue;
                    if(nr==bnr && nc==bnc) continue;
                    redVisited[nr][nc]=true;
                    blueVisited[bnr][bnc]=true;
                    dfs(nr,nc,bnr, bnc,cnt+1);    
                    redVisited[nr][nc]=false;
                    blueVisited[bnr][bnc]=false;
                }
            }
            for(int d=0; d<4; d++){
                int nr = blueR+dr[d];
                int nc = blueC+dc[d];
                if(nr<0 || nr>=r || nc<0 || nc>=c || arr[nr][nc]==5 || blueVisited[nr][nc]) continue;
                if(nr==redR && nc==redC) continue;
                for(int dd=0 ;dd<4; dd++){
                    int bnr = redR+dr[dd];
                    int bnc = redC+dc[dd];
                    if(bnr<0 || bnr>=r || bnc<0 || bnc>=c || arr[bnr][bnc]==5 || redVisited[bnr][bnc]) continue;
                    if(nr==bnr && nc==bnc) continue;
                    blueVisited[nr][nc]=true;
                    redVisited[bnr][bnc]=true;
                    dfs(bnr,bnc,nr, nc,cnt+1);    
                    blueVisited[nr][nc]=false;
                    redVisited[bnr][bnc]=false;
                }
            }
        }
    }
}