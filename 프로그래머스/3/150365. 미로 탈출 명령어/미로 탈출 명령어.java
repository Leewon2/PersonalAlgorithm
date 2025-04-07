import java.util.*;
class Solution {
    final int[] dr = {1,0,0,-1};
    final int[] dc = {0,-1,1,0};
    final String[] name = {"d","l","r","u"};
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int dist = Math.abs(x - r) + Math.abs(y - c);
        if(dist > k || (k - dist) % 2 != 0) return "impossible";
        
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->{
            return o1.sb.toString().compareTo(o2.sb.toString());
        });
        q.offer(new Node(x-1,y-1,0,new StringBuilder()));
        while(!q.isEmpty()){
            Node poll = q.poll();
            if(poll.rr==r-1 && poll.cc==c-1 && poll.dist==k) return poll.sb.toString();
            if(poll.dist>=k) continue;
            for(int i=0; i<4; i++){
                int nr = poll.rr+dr[i];
                int nc = poll.cc+dc[i];
                int remain = k - (poll.dist + 1);
                int need = Math.abs(nr - (r-1)) + Math.abs(nc - (c-1));
                if(need > remain) continue;
                if(nr<0 || nc<0 || nr>=n || nc>=m) continue;
                StringBuilder sb = new StringBuilder(poll.sb);
                sb.append(name[i]);
                q.offer(new Node(nr,nc,poll.dist+1,sb));
            }
        }
        
        return "impossible";
    }
    
    
    
    private class Node{
        int rr;
        int cc;
        int dist;
        StringBuilder sb;
        public Node(int rr, int cc, int dist, StringBuilder sb){
            this.rr=rr;
            this.cc=cc;
            this.dist=dist;
            this.sb=sb;
        }
    }
}