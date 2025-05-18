class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        int prev=numLog[0];
        for(int i=1; i<numLog.length; i++){
            if(prev+1==numLog[i]) answer+="w";
            else if(prev-1==numLog[i]) answer+="s";
            else if(prev+10==numLog[i]) answer+="d";
            else answer+="a";
            prev=numLog[i];
        }
        return answer;
    }
}