class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        int e=0;
        for(int i=0; i<myString.length(); i++){
            int cnt=0;
            for(int j=i; j<i+pat.length(); j++){
                if(j>=myString.length()) break;
                if(myString.charAt(j)!=pat.charAt(j-i)) break;
                cnt++;
            }
            if(cnt==pat.length()) e = i+pat.length();
        }
        for(int i=0; i<e; i++){
            answer+=myString.charAt(i);
        }
        return answer;
    }
}