class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length*k];
        int idx=0;
        for(int i=0; i<picture.length; i++){
            String str = "";
            for(int j=0; j<picture[i].length(); j++){
                for(int kk=0; kk<k; kk++){
                    str+=picture[i].charAt(j);
                }
            }
            for(int j=0; j<k; j++){
                answer[idx++]=str;
            }
        }
        return answer;
    }
}