import java.util.*;
class Solution {
    int[] dr = {1,0,-1,0};
    int[] dc = {0,1,0,-1};
    public int[] solution(String[][] places) {
        // 현재 앉은 자리에 대해서, 갈 수 있는지 여부와 길이를 모두 구해버리자.
        int[] answer = new int[5];
        
        for(int i=0; i<5; i++){
            int res=1;
            String[] sub = places[i];
            String[][] arr = new String[5][5];
            for(int j=0; j<5; j++){
                arr[j] = sub[j].split("");
            }
            for(int r=0; r<5; r++){
                for(int c=0; c<5; c++){
                    if(arr[r][c].equals("P")){
                        res = Math.min(res, find(r,c,arr));
                    }
                }
            }
            answer[i] = res;
        }
        return answer;
    }
    public int find(int row, int col, String[][] arr){
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        q.offer(new Node(row,col,0));
        visited[row][col]=true;
        while(!q.isEmpty()){
            Node node = q.poll();
            if(arr[node.r][node.c].equals("P") && node.dist<=2 &&(node.r!=row || node.c!=col)) {
                return 0;
            }
            for(int i=0; i<4; i++){
                int nr = node.r+dr[i];
                int nc = node.c+dc[i];
                if(nr<0 || nc<0 || nr>=5 || nc>=5 || arr[nr][nc].equals("X") || visited[nr][nc]) continue;
                q.offer(new Node(nr,nc,node.dist+1));
                visited[nr][nc]=true;
            }
        }
        return 1;
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