class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for(int i=0; i<num_list.length; i++){
            int s = num_list[i];
            while(s!=1){
                if(s%2==0) s/=2;
                else{
                    s--;
                    s/=2;
                }
                answer++;
            }
        }
        return answer;
    }
}