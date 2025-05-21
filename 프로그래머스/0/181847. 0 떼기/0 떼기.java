class Solution {
    public String solution(String n_str) {
        String answer = "";
        boolean check = false;
        for(int i=0; i<n_str.length(); i++){
            if(check) answer+=n_str.charAt(i);
            else{
                int idx=0;
                if(n_str.charAt(idx)=='0'){
                    while(idx<n_str.length()){
                        idx++;
                        if(n_str.charAt(idx)!='0') break;
                    }
                }
                i=idx-1;
            }
            check =  true;
            
        }
        return answer;
    }
}