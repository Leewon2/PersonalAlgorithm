import java.util.*;
class Solution {
    final int[] dr = {1,0,-1,0};
    final int[] dc = {0,1,0,-1};
    public int[] solution(String[] maps) {
        int r = maps.length;
        int c = maps[0].length();
        boolean[][] visited = new boolean[r][c];
        Queue<Node> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(!visited[i][j] && maps[i].charAt(j)!='X'){
                    int sum = Character.getNumericValue(maps[i].charAt(j));
                    q.offer(new Node(i,j));
                    visited[i][j] = true;
                    while(!q.isEmpty()){
                        Node poll = q.poll();
                        for(int d=0; d<4; d++){
                            int nr = poll.r+dr[d];
                            int nc = poll.c+dc[d];
                            if(nr<0 || nc<0 || nr>=r || nc>=c || visited[nr][nc] || maps[nr].charAt(nc)=='X') continue;
                            visited[nr][nc]=true;
                            q.offer(new Node(nr,nc));
                            sum+=Character.getNumericValue(maps[nr].charAt(nc));
                        }
                    }
                    pq.offer(sum);
                }
            }
        }
        if(pq.size()==0) return new int[]{-1};
        int[] answer = new int[pq.size()];
        int idx=0;
        while(!pq.isEmpty()){
            answer[idx++] = pq.poll();
        }
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