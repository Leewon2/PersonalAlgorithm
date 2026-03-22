import java.util.*;
class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        // 문자열 길이를 생각해서 스포일러 방지인지 확인한 후, 스포일러라면 q에 아니라면 다른 map이나 set에
        String[] arr = message.split(" ");
        int[] size = new int[arr.length+1];
        boolean[] spo = new boolean[arr.length];
        int sum=0;
        for(int i=0; i<=arr.length; i++){
            size[i] = sum;
            if(i==arr.length) break;
            sum+=arr[i].length()+1;
            // 공백 추가
        }
        for(int[] i : spoiler_ranges){
            int s = i[0];
            int e = i[1];
            for(int j=0; j<size.length; j++){
                if(size[j]<=e && size[j+1]-2>=s){
                    spo[j] = true;
                }
            }
        }
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for(int i=0; i<spo.length; i++){
            if(spo[i]){
                q.offer(arr[i]);
            }else{
                set.add(arr[i]);
            }
        }
        while(!q.isEmpty()){
            String s = q.poll();
            if(!set.contains(s)){
                set.add(s);
                answer++;
            }
        }
        return answer;
    }
}