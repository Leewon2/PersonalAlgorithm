class Solution {
    int playTime;
    int advTime;
    long[] suffix;
    public String solution(String play_time, String adv_time, String[] logs) {
        int time = makeTime(play_time);
        int advTime = makeTime(adv_time);
        suffix = new long[time+1];
        for(int i=0; i<logs.length; i++){
            String[] log = logs[i].split("-");
            suffix[makeTime(log[0])]++;
            suffix[makeTime(log[1])]--;
        }
        long[] dp = new long[suffix.length];
        int startTime = 0;
        dp[0] = suffix[0];
        // dp 계산
        for(int i=1; i<dp.length; i++){
            dp[i] = suffix[i]+dp[i-1];
        }
        // 초기 계산
        long compareMax = 0;
        for(int i=0; i<advTime; i++){
            compareMax+=dp[i];
        }
        long maxTime = compareMax;
        
        for(int i=advTime; i<dp.length; i++){
            compareMax-=dp[i-advTime];
            compareMax+=dp[i];
            if(compareMax>maxTime){
                maxTime = compareMax;
                startTime = i-advTime+1;
            }
        }
        int h = startTime/3600;
        int m = (startTime%3600)/60;
        int s = startTime%60;
        
        return String.format("%02d:%02d:%02d", h, m, s);
    }
    
    private int makeTime(String s){
        String[] arr = s.split(":");
        return transfer(arr[0])*3600+transfer(arr[1])*60+transfer(arr[2]);
    }
    
    private int transfer(String str){
        return Integer.parseInt(str);
    }
}