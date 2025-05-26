
class Solution {
    public String solution(String polynomial) {
        polynomial+=" ";
        String answer = "";
        int xCnt =0;
        int cnt=0;
        String str="";
        for(int i=0; i<polynomial.length(); i++){
            if(polynomial.charAt(i)==' ' || polynomial.charAt(i)=='+') {
                if(!str.equals("")) cnt+=Integer.parseInt(str);
                str="";
            }
            else{
                if(polynomial.charAt(i)=='x'){
                    if(str.equals("")) xCnt+=1;
                    else xCnt+=Integer.parseInt(str);
                    str="";
                }else{
                    str+=polynomial.charAt(i);
                }
            }
        }
        if(xCnt==1){
            if(cnt==0){
                answer = "x";
            }else{
                answer = "x + "+cnt;
            }
        }else if(xCnt==0){
            answer=cnt+"";
        }
        else{
            if(cnt==0){
                answer = xCnt+"x";
            }else{
                answer = xCnt+"x + "+cnt;
            }
        }
        return answer;
    }
}