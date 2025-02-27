class Solution {
    public int solution(int[] num_list) {
        int len = num_list.length;
        if(len<=10){
            int answer = 1;
            for(int i=0; i<len; i++){
                answer*=num_list[i];
            }
            return answer;
        }
        int answer = 0;
        for(int i=0; i<len; i++){
            answer+=num_list[i];
        }
        return answer;
    }
}