class Solution {
    public String solution(String code) {
        // false = 0;
        boolean mode = false;
        int idx=0;
        String answer = "";
        for(int i=0; i<code.length(); i++){
            if(code.charAt(i)=='1') mode=!mode;
            else{
                if(!mode){
                    if(i%2==0) answer+=code.charAt(i);
                }
                else{
                    if(i%2==1) answer+=code.charAt(i);
                }
            }
        }
        if(answer.equals("")) return "EMPTY";
        return answer;
    }
}