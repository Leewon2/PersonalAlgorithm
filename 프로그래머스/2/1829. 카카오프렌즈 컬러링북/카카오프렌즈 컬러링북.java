import java.util.*;
class Solution {
    int[] dr = {1,0,-1,0};
    int[] dc = {0,1,0,-1};
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        int[][] arr = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<Node> q = new LinkedList<>();
        int max=0;
        for(int row=0; row<m; row++){
            for(int col=0; col<n; col++){
                if(picture[row][col]==0 || visited[row][col]) continue;
                int num = picture[row][col];
                int cnt=0;
                q.offer(new Node(row,col));
                while(!q.isEmpty()){
                    Node poll = q.poll();
                    if(visited[poll.r][poll.c]) continue;
                    visited[poll.r][poll.c] = true;
                    cnt++;
                    for(int d=0; d<4; d++){
                        int nr = poll.r+dr[d];
                        int nc = poll.c+dc[d];
                        if(nr<0 || nc<0 || nr>=m || nc>=n || visited[nr][nc]) continue;
                        if(picture[nr][nc]==num)q.offer(new Node(nr,nc));
                    }
                }
                max = Math.max(max, cnt);
                numberOfArea++;
            }
        }
        answer[0] = numberOfArea;
        answer[1] = max;
        return answer;
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