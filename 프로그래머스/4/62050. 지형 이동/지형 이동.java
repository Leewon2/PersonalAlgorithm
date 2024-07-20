import java.util.*;

class Solution {
    public int solution(int[][] land, int height) {
        int cnt=0;
        int ladder =0;
        final int[] dr = {1,0,-1,0};
        final int[] dc = {0,1,0,-1};
        boolean[][] visited = new boolean[land.length][land[0].length];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0));
        visited[0][0] = true;
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2)->{
                return o1.d-o2.d;
            });
        while(cnt<land.length*land[0].length){
            
            
            while(!q.isEmpty()){
                cnt++;
                Node poll = q.poll();
                for(int i=0; i<4; i++){
                    int nr = poll.r+dr[i];
                    int nc = poll.c+dc[i];
                    if(nr<0 || nc<0 || nr>=land.length || nc>=land[0].length || visited[nr][nc]) continue;
                    // 높이차가 가능하면 q에 넣고 방문처리
                    if(Math.abs(land[nr][nc]-land[poll.r][poll.c])<=height){
                        q.offer(new Node(nr,nc));
                        visited[nr][nc] = true;
                    }
                    // 불가하면 pq에 넣기
                    else{
                        pq.offer(new Edge(nr,nc,Math.abs(land[nr][nc]-land[poll.r][poll.c])));
                    }
                }
            }
            if(cnt>=land.length*land[0].length) break;
            // 전체 배열을 순회하면서, 다음 스타트 포인트 찾기
            while(!pq.isEmpty()){
                Edge poll = pq.poll();
                if(!visited[poll.r][poll.c]){
                    q.offer(new Node(poll.r,poll.c));
                    visited[poll.r][poll.c]=true;
                    ladder+=poll.d;
                    break;
                }
            }
            // Node peek = q.peek();
            // System.out.println(ladder);
            // System.out.println("sr : "+peek.r+" sc : "+peek.c);
//             int startr=0;
//             int startc=0;
//             int minDist=Integer.MAX_VALUE;
//             for(int r=0; r<land.length; r++){
//                 for(int c=0; c<land[0].length; c++){
//                     if(!visited[r][c]){
//                         // 방문하지 않았고, 주위에 방문했던 친구가 있으면, 차이를 구한다.
//                         for(int i=0; i<4; i++){
//                             int nr = r+dr[i];
//                             int nc = c+dc[i];
//                             if(nr<0 || nc<0 || nr>=land.length || nc>=land[0].length || !visited[nr][nc]) continue;
//                             if(minDist>Math.abs(land[nr][nc]-land[r][c])){
//                                 startr=r;
//                                 startc=c;
//                                 minDist=Math.abs(land[nr][nc]-land[r][c]);
//                             }
//                         }
//                     }
//                 }
//             }
 
//             q.offer(new Node(startr,startc));
//             visited[startr][startc]=true;
//             ladder+=minDist;
            
        }
        
        return ladder;
    }
    private static class Edge{
        int r;
        int c;
        int d;
        public Edge(int r, int c, int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }
    
    private static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
}