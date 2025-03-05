class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        for(int i=my_string.length()-1; i>=my_string.length()-n; i--){
            answer = my_string.charAt(i)+answer;
        }
        return answer;
    }
}