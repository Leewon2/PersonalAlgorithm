class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int idx=0;
        String num="";
        int[] res = new int[3];
        for(int i=0; i<dartResult.length(); i++){
            char c = dartResult.charAt(i);
            if(c>='0' && c<='9'+1){
                num+=String.valueOf(c);
            }else if(c=='S' || c=='D' || c=='T'){
                int number = Integer.parseInt(num);
                if(c=='S'){
                    res[idx++] = (int) Math.pow(number, 1);
                }else if(c=='D'){
                    res[idx++] = (int) Math.pow(number, 2);
                }else{
                    res[idx++] = (int) Math.pow(number, 3);
                }
                num="";
            }else{
                if(c=='*'){
                    res[idx-1]*=2;
                    if(idx-2>=0) res[idx-2]*=2;
                }else{
                    res[idx-1]*=-1;
                }
            }
        }
        
        return res[0]+res[1]+res[2];
    }
}