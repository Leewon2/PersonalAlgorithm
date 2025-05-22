class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        int len = my_string.length()%m==0 ? my_string.length()/m : my_string.length()/m+1;
        char[][] arr = new char[len][m];
        for(int i=0; i<len; i++){
            for(int j=0; j<m; j++){
                if(i*m+j>=my_string.length()) continue;
                arr[i][j] = my_string.charAt(i*m+j);
            }
        }
        for(int i=0; i<len; i++){
            answer+=arr[i][c-1];
        }
        return answer;
    }
}