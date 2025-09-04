import java.util.*;
class Solution {
    public int solution(int[] food_times, long k) {
        int answer = 0;
        int[][] arr = new int[food_times.length][2];
        for(int i=0; i<food_times.length; i++){
            arr[i][0] = food_times[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (o1,o2)->{
            return o1[0]-o2[0];
        });
        long depth = 0;
        long prev = 0;
        for(int i=0; i<arr.length; i++){
            long now = arr[i][0];
            depth = now - prev;
            long compare = (arr.length-i) * depth;
            if(k<compare){
                int[] a = new int[arr.length-i];
                for(int j=i; j<arr.length; j++){
                    a[j-i] = arr[j][1];
                }
                Arrays.sort(a);
                long c = k%a.length;
                return a[(int) c]+1;
            }
            k-=compare;
            prev = now;
            
        }
        
        return -1;
    }
    
    private class Food{
        int idx;
        int time;
        public Food(int idx, int time){
            this.idx=idx;
            this.time=time;
        }
    }
}