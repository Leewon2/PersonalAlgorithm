class Solution {
    public int solution(String[] lines) {
        int answer = 1;
        // 완탐
        // 시를 기준으로 나누기, double형식으로 표현
        double[][] arr = new double[lines.length][2];
        for(int i=0; i<lines.length; i++){
            String[] str = lines[i].split(" ");
            String[] number = str[1].split(":");
            arr[i][1] += Double.parseDouble(number[0])*3600 + Double.parseDouble(number[1])*60 + 
                Double.parseDouble(number[2]);
            
            arr[i][0] = arr[i][1]-Double.parseDouble(str[2].replace("s","")) +0.001;
            arr[i][0] = Math.round(arr[i][0] * 1000) / 1000.0;
            arr[i][1] = Math.round(arr[i][1] * 1000) / 1000.0;
        }
        
        for(int i=0; i<lines.length; i++){
            int cnt=1;
            
            for(int j=i+1; j<lines.length; j++){
                if(arr[i][1]+1>arr[j][0]) {
                    cnt++;
                    if(j==lines.length-1){
                        answer = Math.max(answer,cnt);
                    }
                }
                else{
                    answer=Math.max(answer,cnt);
                    
                }
            }
        }
        
        return answer;
    }
}