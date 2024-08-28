import java.util.*;
class Solution {
    static int cnt;
    static boolean[] visited;
    public int solution(int[] cards) {
        int answer = 0;
        visited = new boolean[cards.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.offer(0);
        for(int i=0; i<cards.length; i++){
            if(!visited[i]){
                cnt=0;
                dfs(cards,i);
                pq.offer(cnt);
            }
        }
        if(pq.size()==1) return 0;
        return pq.poll()*pq.poll();
    }
    private static void dfs(int[] cards, int idx){
        cnt++;
        visited[idx]=true;
        if(!visited[cards[idx]-1]){
            dfs(cards, cards[idx]-1);
        }
    }
}