import java.util.*;
class Solution {
    Map<String, Integer> map;
    int[] dr = {1,0,-1,0};
    int[] dc = {0,1,0,-1};
    int len;
    PriorityQueue<Node> pq;
    public int solution(int[][] board) {
        len = board.length;
        map = new HashMap<>();

        pq = new PriorityQueue<>((o1,o2)-> o1.dist-o2.dist);
        pq.offer(new Node(0,0,0,1,0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if((node.r1==len-1 && node.c1==len-1) || (node.r2==len-1 && node.c2==len-1)) return node.dist;
            String str = node.r1+","+node.c1+","+node.r2+","+node.c2;
            if(node.dist>=map.getOrDefault(str,Integer.MAX_VALUE)) continue;
            map.put(str, node.dist);
            for(int i=0; i<4; i++){
                int nr1 = node.r1+dr[i];
                int nc1 = node.c1+dc[i];
                int nr2 = node.r2+dr[i];
                int nc2 = node.c2+dc[i];
                if(nr1<0 || nr2<0 || nc1<0 || nc2<0 || nr1>=len || nr2>=len || nc1>=len ||nc2>=len) continue;
                if(board[nr1][nc1]==1 ||board[nr2][nc2]==1) continue;
                String s = nr1+","+nc1+","+nr2+","+nc2;
                duplication(s, nr1, nc1, nr2,nc2,node.dist);
            }

            if(node.r1==node.r2){
                spinW(node.r1, node.c1, node.r2, node.c2,1, board, node.dist);
                spinW(node.r1, node.c1, node.r2, node.c2,-1, board, node.dist);
                spinW(node.r2, node.c2, node.r1, node.c1,1, board, node.dist);
                spinW(node.r2, node.c2, node.r1, node.c1,-1, board, node.dist);
            }

            else{
                spinH(node.r1, node.c1, node.r2, node.c2,1, board, node.dist);
                spinH(node.r1, node.c1, node.r2, node.c2,-1, board, node.dist);
                spinH(node.r2, node.c2, node.r1, node.c1,1, board, node.dist);
                spinH(node.r2, node.c2, node.r1, node.c1,-1, board, node.dist);
            }
        }
        
        return 0;
    }
    // 가로
    // 왼쪽이 축이 될때는 오른쪽이 왼쪽의 위(오른쪽 위는 비어있어야함) and 왼쪽의 아래로(오른쪽 아래 비어있어야함)
    // 오른쪽이 축이 될때는 왼쪽이 오른쪽의 위(왼쪽 위는 비어있어야함) and 오른쪽의 아래(왼쪽 아래 비어있어야함)
    private void spinW(int r1, int c1, int r2, int c2, int cnt, int[][] board, int dist){
        if(r1+cnt<0 || r1+cnt>=len) return;
        if(board[r2+cnt][c2]==1 || board[r1+cnt][c1]==1) return;
        String s = r1+","+c1+","+(r1+cnt)+","+c1;
        duplication(s, r1, c1, r1+cnt, c1, dist);
    }
    
    // 세로
    // 위가 축이 될때는 아래가 위의 오른쪽으로 옴(아래의 오른쪽이 비어있어야함)
    // 아래가 위의 왼쪽으로옴(아래의 왼쪽이 비어있어야함)
    // 아래가 축이 될때는 아래의 오른쪽, 왼쪽으로 옴(위의 왼,오가 비어있어야함)
    private void spinH(int r1, int c1, int r2, int c2, int cnt, int[][] board, int dist){
        if(c1+cnt<0 || c1+cnt>=len) return;
        if(board[r2][c2+cnt]==1 || board[r1][c1+cnt]==1) return;
        String s = r1+","+c1+","+r1+","+(c1+cnt);
        duplication(s, r1, c1, r1, c1+cnt,dist);
    }
    
    private void duplication(String s, int r1, int c1, int r2, int c2,int dist){
        if(dist>=map.getOrDefault(s,Integer.MAX_VALUE)) return;
        pq.offer(new Node(r1,c1,r2,c2,dist+1));
    }

    private class Node{
        int r1;
        int c1;
        int r2;
        int c2;
        int dist;
        public Node(int r1, int c1, int r2, int c2, int dist){
            this.r1=r1;
            this.c1=c1;
            this.r2=r2;
            this.c2=c2;
            this.dist=dist;
        }
    }
}