class Solution {
    public int solution(String[] babbling) {
        char[] arr = {'0','1','2','3'};
        int answer = 0;
        for(int i=0; i<babbling.length; i++){
            String str = babbling[i];
            boolean[] use = new boolean[4];
            
            str=str.replace("aya","0");
            str=str.replace("ye","1");
            str=str.replace("woo","2");
            str=str.replace("ma","3");
            boolean check = false;
            outer : for(int j=0; j<str.length(); j++){
                if(str.charAt(j)-'0'<0 || str.charAt(j)-'0'>3) {
                    check=false;
                    break;
                }
                for(int k=0; k<4; k++){
                    if(str.charAt(j)==arr[k]){
                        check = true;
                        if(use[k]) {
                            check = false;
                            break outer;
                        }
                        use = new boolean[4];
                        use[k] = true;
                    }
                    
                }
                if(!check) break;
            }
            if(check) answer++;
        }
        return answer;
    }
}