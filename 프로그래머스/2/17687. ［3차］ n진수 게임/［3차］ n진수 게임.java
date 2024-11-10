class Solution {
    public String solution(int n, int t, int m, int p) {
        
        String answer = "";
        int num = 0;
        int time = 0;
        while(t>0){
            String str = Integer.toString(num,n);
            for(int i=0; i<str.length(); i++){
                if(time%m==p-1) {
                    answer+=str.charAt(i);
                    t--;
                    if(t==0) break;
                }
                time++;
            }
            num++;
            
        }
        answer=answer.toUpperCase();
        return answer;
    }
}