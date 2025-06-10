import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        PriorityQueue<DataAnalysis> pq;
        if(sort_by.equals("code")){
            pq = new PriorityQueue<>((o1,o2)->{
                return o1.code-o2.code;
            });
        }else if(sort_by.equals("date")){
            pq = new PriorityQueue<>((o1,o2)->{
                return o1.date-o2.date;
            });
        }else if(sort_by.equals("maximum")){
            pq = new PriorityQueue<>((o1,o2)->{
                return o1.maximum-o2.maximum;
            });
        }else{
            pq = new PriorityQueue<>((o1,o2)->{
                return o1.remain-o2.remain;
            });
        }
        for(int i=0; i<data.length; i++){
            if(ext.equals("date")){
                if(data[i][1]<val_ext) pq.offer(new DataAnalysis(data[i][0],data[i][1],data[i][2],data[i][3]));
            }else if(ext.equals("code")){
                if(data[i][0]<val_ext) pq.offer(new DataAnalysis(data[i][0],data[i][1],data[i][2],data[i][3]));
            }else if(ext.equals("maximum")){
                if(data[i][2]<val_ext) pq.offer(new DataAnalysis(data[i][0],data[i][1],data[i][2],data[i][3]));
            }else{
                if(data[i][3]<val_ext) pq.offer(new DataAnalysis(data[i][0],data[i][1],data[i][2],data[i][3]));
            }
                
        }
        int[][] answer = new int[pq.size()][4];
        for(int i=0; i<answer.length; i++){
            DataAnalysis d = pq.poll();
            answer[i][0] = d.code;
            answer[i][1] = d.date;
            answer[i][2] = d.maximum;
            answer[i][3] = d.remain;
        }
        
        return answer;
    }
    
    private class DataAnalysis{
        int code;
        int date;
        int maximum;
        int remain;
        public DataAnalysis(int code, int date, int maximum, int remain){
            this.code=code;
            this.date=date;
            this.maximum=maximum;
            this.remain=remain;
        }
    }
}