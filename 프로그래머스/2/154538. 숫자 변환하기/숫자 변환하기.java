import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        return bfs(x,y,n);
    }
    private int bfs(int x, int y, int n){
        Queue<int[]> q = new LinkedList<>();
        boolean[] use = new boolean[3000001];
        q.offer(new int[] {x,0});
        while(!q.isEmpty()){
            int[] poll = q.poll();
            if(poll[0]==y) return poll[1];
            if(poll[0]>y) continue;
            if(poll[0]+n <= y && !use[poll[0]+n]) {
                q.offer(new int[] {poll[0]+n,poll[1]+1});
                use[poll[0]+n] = true;
            }
            if(poll[0]*2 <= y && !use[poll[0]*2]) {
                q.offer(new int[] {poll[0]*2,poll[1]+1});
                use[poll[0]*2] = true;
            }
            if(poll[0]*3 <= y && !use[poll[0]*3]) {
                q.offer(new int[] {poll[0]*3,poll[1]+1});
                use[poll[0]*3] = true;
            }
        }
        return -1;
    }
}