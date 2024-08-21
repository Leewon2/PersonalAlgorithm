import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] arr = new int[timetable.length];
        for(int i=0; i<timetable.length; i++){
            String[] str = timetable[i].split(":");
            pq.offer(Integer.parseInt(str[0])*60 + Integer.parseInt(str[1]));
        }
        int start = 9*60-t;;
        int con = 0;
        for(int i=0; i<n; i++){
            start+=t;
            for(int j=0; j<m; j++){
                // 마지막 탑승
                if(i==n-1 && j==m-1){
                    if(pq.isEmpty()) con = start;
                    else con = Math.min(pq.peek()-1,start);
                    break;
                }
                
                if(!pq.isEmpty() && pq.peek()<=start){
                    pq.poll();
                }else{
                    if(i==n-1) con=start;
                }
            }
        }
        String newTime = "0";
        String time = Integer.toString(con/60);
        String minute = Integer.toString(con%60);
        if(time.length()==1){
            time = newTime+time;
        }
        if(minute.length()==1){
            minute=newTime+minute;
        }
        
        return time+":"+minute;
    }
}