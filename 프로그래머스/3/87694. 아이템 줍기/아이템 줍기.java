import java.util.*;
class Solution {
    static boolean[][] map;
    static boolean[][] load;
    static final int[] dr = {1,0,-1,0,1,1,-1,-1};
    static final int[] dc = {0,1,0,-1,1,-1,1,-1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        map = new boolean[106][106];
        load = new boolean[106][106];
        for(int i=0; i<rectangle.length; i++){
            for(int j=0; j<rectangle[0].length; j++){
                int leftY = rectangle[i][0]*2+1;
                int leftX = rectangle[i][1]*2+1;
                int rightY = rectangle[i][2]*2+1;
                int rightX = rectangle[i][3]*2+1;
                for(int r=leftX; r<=rightX; r++){
                    for(int c=leftY; c<=rightY; c++){
                        map[r][c]=true;
                    }
                }
            }
        }
        for(int i=1; i<105; i++){
            for(int j=1; j<105; j++){
                if(map[i][j]){
                    for(int d=0; d<8; d++){
                        int nr = i+dr[d];
                        int nc = j+dc[d];
                        if(nr<0 || nc<0 || map[nr][nc]) continue;
                        load[i][j] = true;
                    }
                }
            }
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(characterY*2+1,characterX*2+1,0));
        
        boolean[][] visited = new boolean[106][106];
        visited[characterY*2+1][characterX*2+1]=true;
        
        while(!q.isEmpty()){
            Node poll = q.poll();
            if(poll.r == itemY*2+1 && poll.c == itemX*2+1) return poll.cost/2;
            
            for(int d=0; d<4; d++){
                int nr = poll.r+dr[d];
                int nc = poll.c+dc[d];
                if(nr<0 || nc<0 || visited[nr][nc] || !load[nr][nc]) continue;
                visited[nr][nc]=true;
                q.offer(new Node(nr,nc,poll.cost+1));
            }
            
        }
        
        
        return answer;
        
    }
    private static class Node{
        int r;
        int c;
        int cost;
        public Node(int r, int c, int cost){
            this.r=r;
            this.c=c;
            this.cost=cost;
        }
    }
    
}