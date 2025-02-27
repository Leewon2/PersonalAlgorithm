import java.util.*;
class Solution {
    Queue<Node> q;
    final int[] dr = {1,0,-1,0};
    final int[] dc = {0,1,0,-1};
    public int solution(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][][] dp = new int[row][col][4];
        q = new LinkedList<>();
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                Arrays.fill(dp[i][j],Integer.MAX_VALUE);
                
            }
        }
        dp[0][0][0]=0;
        dp[0][0][1]=0;
        dp[0][0][2]=0;
        dp[0][0][3]=0;
        q.offer(new Node(0,0,0));
        q.offer(new Node(0,0,1));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(!q.isEmpty()){
            Node poll = q.poll();
            if(poll.r==row-1 && poll.c==col-1) pq.offer(dp[poll.r][poll.c][poll.dir]);
            for(int i=0; i<4; i++){
                int nr = poll.r+dr[i];
                int nc = poll.c+dc[i];
                if(nr<0 || nc<0 || nr>=row || nc>=row || board[nr][nc]==1) continue;
                if(i==poll.dir){
                    
                    if(dp[nr][nc][i]>=dp[poll.r][poll.c][i]+1){
                        dp[nr][nc][i]=dp[poll.r][poll.c][i]+1;
                        q.offer(new Node(nr,nc,i));
                    }
                }else{
                    if(dp[nr][nc][i]>=dp[poll.r][poll.c][poll.dir]+6){
                        dp[nr][nc][i]=dp[poll.r][poll.c][poll.dir]+6;
                        q.offer(new Node(nr,nc,i));
                    }
                }
                
            }
        }
        return pq.poll()*100;
    }
    
    private class Node{
        int r;
        int c;
        int dir;
        public Node(int r, int c,int dir){
            this.r=r;
            this.c=c;
            this.dir=dir;
            ;
        }
    }
}