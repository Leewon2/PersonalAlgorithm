import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        PriorityQueue<Num> pq = new PriorityQueue<>((o1,o2)->{
            if(o1.number!=o2.number) return o1.number-o2.number;
            return o2.realNumber-o1.realNumber;
        });
        int[] answer = new int[numlist.length];
        for(int i=0; i<numlist.length; i++){
            pq.offer(new Num(Math.abs(numlist[i]-n),numlist[i]));
        }
        int idx=0;
        while(!pq.isEmpty()) answer[idx++]=pq.poll().realNumber;
        return answer;
    }
    private class Num{
        int number;
        int realNumber;
        public Num(int number, int realNumber){
            this.number=number;
            this.realNumber=realNumber;
        }
    }
}