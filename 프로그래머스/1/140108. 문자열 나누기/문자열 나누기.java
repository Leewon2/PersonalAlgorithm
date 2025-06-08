class Solution {
    public int solution(String s) {
        int answer = 1;
        int left=0;
        int right=0;
        int idx=0;
        char now=' ';
        while(idx<s.length()){
            if(left!=0 && left==right) {
                answer++;
                left=0;
                right=0;
                continue;
            }else if(left==0){
                now = s.charAt(idx++);
                left++;
            }else{
                if(now==s.charAt(idx++)) left++;
                else right++;
            }
        }
        return answer;
    }
}