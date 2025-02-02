import java.util.*;
class Solution {
    final int[] dr = {1,0,-1,0};
    final int[] dc = {0,1,0,-1};
    int[][] arr;
    boolean[][] visited;
    int r;
    int c;
    public int solution(String[] maps) {
        int answer = 0;
        r = maps.length;
        c = maps[0].length();
        int startR=0, startC=0, labberR=0, labberC=0, endR=0, endC=0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(maps[i].charAt(j)=='S'){
                    startR=i;startC=j;
                }else if(maps[i].charAt(j)=='L'){
                    labberR=i; labberC=j;
                }else if(maps[i].charAt(j)=='E'){
                    endR=i; endC=j;
                }
            }
        }
        int toLabber = bfs(startR,startC,labberR,labberC,maps);
        int toEnd = bfs(labberR,labberC,endR,endC,maps);
        if(toLabber==0 || toEnd==0) return -1;
        return toLabber+toEnd;
    }
    public int bfs(int sR, int sC, int targetR, int targetC, String[] maps){
        arr = new int[r][c];
        visited = new boolean[r][c];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sR,sC));
        outer : while(!q.isEmpty()){
            Node poll = q.poll();
            if(poll.r==targetR && poll.c==targetC){
                break outer;
            }
            if(visited[poll.r][poll.c]) continue;
            visited[poll.r][poll.c]=true;
            for(int i=0; i<4; i++){
                int nr = poll.r+dr[i];
                int nc = poll.c+dc[i];
                if(nr<0||nc<0||nr>=r||nc>=c||visited[nr][nc]||maps[nr].charAt(nc)=='X') continue;
                q.offer(new Node(nr,nc));
                arr[nr][nc]=arr[poll.r][poll.c]+1;
            }
        }
        return arr[targetR][targetC];
    }
    private class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
}