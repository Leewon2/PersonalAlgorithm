import java.util.*;
class Solution {
    int[] dr = {1,0,-1,0};
    int[] dc = {0,1,0,-1};
    int[][] arr;
    int N;
    int answer;
    boolean check;
    public int solution(int[][] board) {
        N = board.length;
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            arr[i] = board[i].clone();
        }
        answer = 0;
        check = true;
        while(check){
            check = false;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(arr[i][j]!=0){
                        int num = findShape(i,j,arr[i][j]);
                        checkValue(i,j,arr[i][j],num);
                    }
                }
            }
        }
        return answer;
    }
    private void deleteIdx(int x, int y, int idx){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        while(!q.isEmpty()){
            Node poll = q.poll();
            if(arr[poll.r][poll.c]==idx){
                arr[poll.r][poll.c] = 0;
            }
            for(int i=0; i<4; i++){
                int nr = poll.r+dr[i];
                int nc = poll.c+dc[i];
                if(nr<0 || nc<0 || nr>=N || nc>=N || arr[nr][nc]!=idx) continue;
                q.offer(new Node(nr,nc));
            }
        }
    }
    private int findShape(int x, int y, int idx){
        if(x+1<N && y+2<N && arr[x+1][y]==idx && arr[x+1][y+1]==idx && arr[x+1][y+2]==idx) return 1;
        else if(x+2<N && y-1>=0 && arr[x+1][y]==idx && arr[x+2][y]==idx && arr[x+2][y-1]==idx) return 2;
        else if(y+1<N && x+2<N && arr[x+1][y]==idx &&arr[x+2][y]==idx &&arr[x+2][y+1]==idx) return 3;
        else if(y-2>=0 && x+1<N && arr[x+1][y]==idx &&arr[x+1][y-1]==idx &&arr[x+1][y-2]==idx) return 4;
        else if(y+1<N && y-1>=0 && x+1<N && arr[x+1][y]==idx &&arr[x+1][y+1]==idx &&arr[x+1][y-1]==idx) return 5;
        else return 0;
    
        
    }
    private boolean drop(int x, int y){
        for(int i=0; i<=x; i++){
            if(arr[i][y]!=0) return false;
        }
        return true;
    }
    
    private void checkValue(int x, int y, int idx, int num){
        if(num==1){
            if(arr[x][y+1]==0 && arr[x][y+2]==0 && drop(x,y+1) && drop(x,y+2)){
                run(x,y,idx);
            }
        }else if(num==2){
            if(arr[x][y-1]==0 && arr[x+1][y-1]==0 && drop(x+1,y-1)){
                run(x,y,idx);
            }
        }else if(num==3){
            if(arr[x][y+1]==0 && arr[x+1][y+1]==0 && drop(x+1,y+1)){
                run(x,y,idx);
            }
        }else if(num==4){
            if(arr[x][y-1]==0 && arr[x][y-2]==0 && drop(x,y-1) && drop(x,y-2)){
                run(x,y,idx);
            }
        }else if(num==5){
            if(arr[x][y-1]==0 && arr[x][y+1]==0 && drop(x,y-1) && drop(x,y+1)){
                run(x,y,idx);
            }
        }
    }
    private void run(int x, int y, int idx){
        check = true;
        answer++;
        deleteIdx(x, y, idx);
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