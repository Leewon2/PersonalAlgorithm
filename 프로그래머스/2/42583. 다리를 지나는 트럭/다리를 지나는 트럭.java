import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck> q = new LinkedList<>();
        int sum = 0;
        int now = 0;
        for(int i=0; i<truck_weights.length; i++){
            int t = truck_weights[i];
            if(!q.isEmpty() && now-q.peek().dist == bridge_length){
                sum-=q.poll().w;
            }
            if(sum+t<=weight){
                sum += t;
                now++;
                q.offer(new Truck(t,now));
            }else {
                while(sum+t>weight){
                    now++;
                    if(now-q.peek().dist==bridge_length){
                        sum-=q.poll().w;
                        
                    }
                }
                sum+=t;
                q.offer(new Truck(t,now));
            }
            // System.out.println("t : "+t+" now : "+now+ " weight : "+q.peek().w+" dist : "+q.peek().dist+ " size : "+q.size()+ " sum : "+sum);
            // System.out.println("now : "+now);
            
        }
        while(!q.isEmpty()){
            now++;
            if(now-q.peek().dist==bridge_length){
                sum-=q.poll().w;
            }
        }
        return now;
    }
    private class Truck{
        int w;
        int dist;
        public Truck(int w, int dist){
            this.w=w;
            this.dist=dist;
        }
    }
}