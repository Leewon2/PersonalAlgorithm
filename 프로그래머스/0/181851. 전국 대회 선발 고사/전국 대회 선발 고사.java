import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        PriorityQueue<Student> pq = new PriorityQueue<>((o1,o2)->{
            return o1.number-o2.number;
        });
        int answer = 0;
        for(int i=0; i<rank.length; i++){
            if(attendance[i]){
                pq.offer(new Student(i,rank[i]));
            }
        }
        int num = 10000;
        for(int i=0; i<3; i++){
            answer+=num*pq.poll().idx;
            num/=100;
        }
        return answer;
    }
    
    private class Student{
        int idx;
        int number;
        public Student(int idx, int number){
            this.idx=idx;
            this.number=number;
        }
    }
}