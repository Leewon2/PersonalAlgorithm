import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            return o1[0]-o2[0];
        });
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for(int i=0; i<records.length; i++){
            String[] arr = records[i].split(" ");
            String[] time = arr[0].split(":");
            int t = Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
            if(arr[2].equals("IN")){
                map.put(arr[1],t);
            }else{
                int parkingTime = t - map.get(arr[1]);
                if(map2.get(arr[1])==null){
                    map2.put(arr[1],parkingTime);
                }else{
                    map2.put(arr[1],parkingTime+map2.get(arr[1]));
                }
                map.remove(arr[1]);
            }
        }
        int lastTime = 23*60+59;
        for(String s : map.keySet()){
            int t = map.get(s);
            int parkingTime = lastTime - t;
            if(map2.get(s)==null){
                map2.put(s,parkingTime);
            }else{
                map2.put(s,parkingTime+map2.get(s));
            }
        }
        for(String s : map2.keySet()){
            int t = map2.get(s);
            int parkingTime = t - fees[0];
            int fee = fees[1];
            if(parkingTime>0){
                int tt = parkingTime/fees[2];
                if(parkingTime%fees[2]!=0) tt++;
                fee+=(tt*fees[3]);
            }
            pq.offer(new int[]{Integer.parseInt(s),fee});

        }

        int[] answer = new int[pq.size()];
        int idx=0;
        while(!pq.isEmpty()){
            answer[idx++] = pq.poll()[1];
        }
        return answer;
    }
}