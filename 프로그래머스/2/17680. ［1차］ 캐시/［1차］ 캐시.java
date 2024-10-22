import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize==0) return cities.length*5;
        Queue<String> q = new LinkedList<>();
        for(int i=0; i<cities.length; i++){
            String str = cities[i].toUpperCase();
            if(q.contains(str)){
                q.remove(str);
                answer++;
            }else{
                if(q.size()==cacheSize)
                    q.poll();
                answer+=5;
            }
            q.offer(str);
        }
        return answer;
    }
}