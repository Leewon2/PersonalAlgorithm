import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        m = deleteHash(m);
        PriorityQueue<Music> pq = new PriorityQueue<>((o1,o2)->{
            if(o1.time!=o2.time) return o2.time-o1.time;
            return o1.idx-o2.idx;
        });
        int now=0;
        for(String s : musicinfos){
            String[] arr = s.split(",");
            String comapreString = deleteHash(arr[3]);
            int time = makeTime(arr[0],arr[1]);
            String str="";
            // 악보의 길이
            int len = comapreString.length();
            int index=0;
            for(int i=0; i<time; i++){
                str+= comapreString.charAt(index++%len);
            }
            if(str.contains(m)){
                pq.offer(new Music(arr[2],time,now++));
            }
        }
        if(pq.size()==0) return "(None)";
        return pq.poll().ans;
    }
    
    public String deleteHash(String str){
        return str.replace("C#","H").replace("D#","I").replace("F#","J").replace("G#","K").replace("A#","L").replace("B#","M");
    }
                                         
    public int makeTime(String start, String end){
        int s = Integer.parseInt(start.substring(0,2))*60 + Integer.parseInt(start.substring(3,5));
        int e = Integer.parseInt(end.substring(0,2))*60 + Integer.parseInt(end.substring(3,5));
        
        return e-s;
    }
    
    private class Music{
        String ans;
        int time;
        int idx;
        public Music(String ans, int time, int idx){
            this.ans=ans;
            this.time=time;
            this.idx=idx;
        }
    }
}