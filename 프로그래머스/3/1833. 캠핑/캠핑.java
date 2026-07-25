import java.util.*;
class Solution {
    public int solution(int n, int[][] data) {
        int answer = 0;
        Arrays.sort(data, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });
        for(int i=0; i<data.length-1; i++){
            int sx1 = data[i][0];
            int sy1 = data[i][1];
            int maxLeftY=-1;
            int minrightY=Integer.MAX_VALUE;
            int updateMaxLeftY=-1;
            int updateMinrightY=Integer.MAX_VALUE;
            for(int j=i+1; j<data.length; j++){
                // 이전의 x값과 다를 때, 모두 모아서 갱신
                if(data[j][0]>data[j-1][0]){
                    maxLeftY=updateMaxLeftY;
                    minrightY=updateMinrightY;
                }
                int sx2 = data[j][0];
                int sy2 = data[j][1];
                if(sx1==sx2) continue;
                
                if(sy1==sy2){
                    if(sy2<sy1){
                        updateMaxLeftY=Math.max(updateMaxLeftY,sy2);
                    }else if(sy2>sy1){
                        updateMinrightY=Math.min(updateMinrightY,sy2);
                    }
                }
                
                else{
                    
                    if(sy2<sy1 && sy2>=maxLeftY){
                        // System.out.println("i : "+i+" j : "+j + "!!!");
                        updateMaxLeftY=Math.max(updateMaxLeftY,sy2);
                        
                        answer++;
                    }else if(sy2>sy1 && sy2<=minrightY){
                        // System.out.println("i : "+i+" j : "+j );
                        updateMinrightY=Math.min(updateMinrightY,sy2);
                        answer++;
                    }
                }
            }
        }
        // for(int[] i : data){
        //     System.out.println(Arrays.toString(i));
        // }
        return answer;
    }
}