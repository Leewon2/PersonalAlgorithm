import java.util.*;
class Solution {
    static final int[] dr ={1,0,-1,0};
    static final int[] dc ={0,1,0,-1};
    static boolean[][] visited;
    static int answer;
    static PriorityQueue<Node> q;
    static Node[][] arr;
    static boolean[] number;
    static boolean[] select;
    static int cnt;
    
    public int solution(int[][] board, int r, int c) {
        answer=Integer.MAX_VALUE;
        select = new boolean[7];
        number = new boolean[7];
        arr= new Node[7][2];
        cnt=0;
         for(int i=0; i<4; i++){
            for(int j=0; j<4;j++){
                if(board[i][j]>0) {
                    if(!number[board[i][j]]){
                        cnt++;
                        number[board[i][j]]= true;
                        arr[board[i][j]][0] = new Node(i,j,0);
                    }else{
                        arr[board[i][j]][1] = new Node(i,j,0);
                    }
                }
            }
        }
        dfs(0,0,new Node(r,c,0),board);
        return answer;
    }
    private void dfs(int res, int depth, Node cur, int[][] board) {
		if (depth == cnt) {
			answer = Math.min(answer, res+cnt*2);
			return;
		}
		for (int i = 1; i <= cnt; i++) {
			if (!select[i] && number[i]) {
				select[i] = true;
				for (int j = 0; j < 2; ++j) {
					Node first = arr[i][j];
					Node second = arr[i][(j + 1) % 2];
					int moveCnt = bfs(cur, board, first) + bfs(first, board, second);

					board[first.r][first.c] = 0;
					board[second.r][second.c] = 0;

					dfs(res + moveCnt, depth + 1, second, board);

					board[first.r][first.c] = i;
					board[second.r][second.c] = i;
				}
				select[i] = false;
			}
		}
	}
    
    private static int bfs(Node start, int[][] board,Node compare){
        q = new PriorityQueue<>((o1,o2)->{
            return o1.cnt-o2.cnt;
        });
        visited = new boolean[4][4];
        q.offer(start);
        while(!q.isEmpty()){
            Node poll = q.poll();
            visited[poll.r][poll.c]=true;
            if(poll.r==compare.r && poll.c==compare.c){
                return poll.cnt;
            }
            for(int i=0; i<4; i++){
            int nr = poll.r+dr[i];
            int nc = poll.c+dc[i];
            if(nr<0 || nc<0 || nr>=4 || nc>=4 || visited[nr][nc]) continue;
                q.offer(new Node(nr,nc,poll.cnt+1));
            }
            for(int i=0; i<4; i++){
                int nr = poll.r;
                int nc = poll.c;
                while(true){
                    nr += dr[i];
                    nc += dc[i];
                    if(nr<0 || nc<0 || nr>=4 || nc>=4) {
                        nr-=dr[i];
                        nc-=dc[i];
                        if(!visited[nr][nc]){
                            q.offer(new Node(nr,nc,poll.cnt+1));
                        }
                        break;
                    }else if(board[nr][nc]>0){
                        if(!visited[nr][nc]){
                            q.offer(new Node(nr,nc,poll.cnt+1));
                        }
                        break;
                    }
                }
            }
        }
        return 0;
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