class Solution {
    public int solution(int n) {
        int answer = 0;
        int idx=0;
        while(idx<n){
            answer++;
            String str = Integer.toString(answer);
            boolean check = true;
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i)=='3') check=false;
            }
            if(answer%3==0) check = false;
            if(check) idx++;
        }
        return answer;
    }
}