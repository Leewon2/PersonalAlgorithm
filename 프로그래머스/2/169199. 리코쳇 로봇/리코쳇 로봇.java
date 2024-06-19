import java.util.*;

class Solution {
    public int solution(String[] board) {
        int startR=0, startC=0, endR=0, endC = 0;
        int c = board[0].length();
        int r = board.length;
        char[][] arr = new char[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                arr[i][j] = board[i].charAt(j);
                if(arr[i][j]=='R'){
                    startR=i;
                    startC=j;
                }else if(arr[i][j]=='G'){
                    endR=i;
                    endC=j;
                }
            }
        }
        int[] dr = {1,0,-1,0};
        int[] dc = {0,1,0,-1};
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startR, startC,0));
        boolean[][] visited = new boolean[r][c];
        visited[startR][startC] = true;
        while(!q.isEmpty()){
            Node poll = q.poll();
            // System.out.println("r : "+poll.r+ " c : "+poll.c+" cnt : "+poll.cnt);
            if(poll.r==endR && poll.c==endC)
                return poll.cnt;
            
            
            for(int i=0; i<4; i++){
                int idx=0;
                outer : while(true){
                    int nrr = poll.r+dr[i]*idx;
                    int ncc = poll.c+dc[i]*idx;
                    int nr = poll.r+dr[i]*(idx+1);
                    int nc = poll.c+dc[i]*(idx+1);
                    if(nrr<0 || ncc<0 || nrr>=r || ncc>=c) break;
                    if(nr<0 || nc<0 || nr>=r || nc>=c || arr[nr][nc]=='D') {
                        if(!visited[nrr][ncc]){
                            q.offer(new Node(nrr,ncc,poll.cnt+1));
                            visited[nrr][ncc]=true;
                        }
                        break outer;
                    }
                    idx++;
                }
            }
        }
        return -1;
    }
    private static class Node{
        int r;
        int c;
        int cnt;
        public Node(int r, int c, int cnt){
            this.r=r;
            this.c=c;
            this.cnt=cnt;
        }
    }
}