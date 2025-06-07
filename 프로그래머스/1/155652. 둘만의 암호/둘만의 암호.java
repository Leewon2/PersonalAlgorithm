class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        String str="";
        for(int i=0; i<26; i++){
            char c = (char)('a'+i);
            boolean check = true;
            for(int j=0; j<skip.length(); j++){
                if(skip.charAt(j)==c) check =false;
            }
            if(check) str+=c;
        }
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            for(int j=0; j<str.length(); j++){
                if(c==str.charAt(j)){
                    c = str.charAt((j+index)%str.length());
                    break;
                }
            }
            answer+=c;
        }
        
        return answer;
    }
}