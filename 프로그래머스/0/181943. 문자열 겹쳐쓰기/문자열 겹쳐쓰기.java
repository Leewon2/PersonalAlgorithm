class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        for(int i=0; i<my_string.length(); i++){
            if(i==s){
                for(int j=s; j<s+overwrite_string.length(); j++){
                    answer+=overwrite_string.charAt(j-s);
                    
                }
                i+=overwrite_string.length()-1;
            }else{
                answer+=my_string.charAt(i);
            }
        }
        return answer;
    }
}