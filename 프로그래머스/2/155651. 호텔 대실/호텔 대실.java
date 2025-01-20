import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            if(o1[0]!=o2[0]) return o1[0]-o2[0];
            return o1[1]-o2[1];
        });
        for(int i=0; i<book_time.length; i++){
            String[] s = book_time[i][0].split(":");
            int start = Integer.parseInt(s[0])*60+Integer.parseInt(s[1]);
            String[] e = book_time[i][1].split(":");
            int end = Integer.parseInt(e[0])*60+Integer.parseInt(e[1])+10;
            pq.offer(new int[]{start,end});
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        while(!pq.isEmpty()){
            int[] poll = pq.poll();
            if(q.isEmpty()) q.offer(poll[1]);
            else{
                if(q.peek()<=poll[0]) q.poll();
                q.offer(poll[1]);
            }
            answer=Math.max(answer,q.size());
        }
        return answer;
    }
}