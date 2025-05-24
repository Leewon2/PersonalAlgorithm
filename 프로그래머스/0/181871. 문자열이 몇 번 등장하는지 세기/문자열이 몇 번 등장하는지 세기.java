class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        for(int i=0; i<myString.length(); i++){
            int cnt=0;
            for(int j=i; j<i+pat.length(); j++){
                if(j>=myString.length()) break;
                if(myString.charAt(j)!=pat.charAt(j-i)) break;
                cnt++;
            }
            if(cnt==pat.length()) answer++;
        }
        return answer;
    }
}