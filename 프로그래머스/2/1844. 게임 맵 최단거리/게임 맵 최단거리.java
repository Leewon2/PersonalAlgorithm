import java.util.*;
class Solution {
    final int[] dr ={1,0,-1,0};
    final int[] dc ={0,1,0,-1};
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        if(maps[0][0]==0 || maps[n-1][m-1]==0) return -1;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0,1));
        visited[0][0] = true;
        while(!q.isEmpty()){
            Node poll = q.poll();
            if(poll.r==n-1 && poll.c==m-1) return poll.dist;
            visited[poll.r][poll.c]=true;
            for(int i=0; i<4; i++){
                int nr = poll.r+dr[i];
                int nc = poll.c+dc[i];
                if(nr<0 || nc<0 || nr>=n || nc>=m || visited[nr][nc] || maps[nr][nc]==0) continue;
                visited[nr][nc]=true;
                q.offer(new Node(nr,nc,poll.dist+1));
            }
        }
        
        
        return -1;
    }
    private class Node{
        int r;
        int c;
        int dist;
        public Node(int r, int c, int dist){
            this.r=r;
            this.c=c;
            this.dist=dist;
        }
    }
}