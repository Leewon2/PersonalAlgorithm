import java.util.*;
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int[] arr = new int[schedules.length];
        for(int i=0; i<schedules.length; i++){
            if((schedules[i]+10)%100>59){
                String str = Integer.toString(schedules[i]);
                int hour = str.length()==3 ? Integer.parseInt(str.substring(0,1))+1 : Integer.parseInt(str.substring(0,2))+1;
                String h = Integer.toString(hour);
                int min = str.length()==3 ? Integer.parseInt(str.substring(1,3))-50 : Integer.parseInt(str.substring(2,4))-50;
                String m = Integer.toString(min);
                if(m.length()==1){
                    m= "0"+m;
                }
                String newString = h+m;
                arr[i] = Integer.parseInt(newString);
            }else{
                arr[i] = schedules[i]+10;
            }
        }
        
        boolean[] check = new boolean[schedules.length];
        for(int i=0; i<timelogs.length; i++){
            int start = startday-2;
            for(int j=0; j<timelogs[i].length; j++){
                start++;
                if(start%7==5 ||start%7==6) continue;
                
                if(timelogs[i][j]>arr[i]) check[i]=true;
            }
        }
        int answer = 0;
        
        for(int i=0; i<check.length; i++){
            if(!check[i]) answer++;
        }
        
        
        return answer;
        
    }
}