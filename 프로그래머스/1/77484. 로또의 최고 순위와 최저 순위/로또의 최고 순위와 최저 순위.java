class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int max=0;
        int min=0;
        for(int i=0; i<lottos.length; i++){
            if(lottos[i]==0){
                max++;
            }
            else{
                for(int j=0; j<win_nums.length; j++){
                    if(lottos[i]==win_nums[j]){
                        max++;
                        min++;
                        break;
                    }
                }
            }
        }
        if(max<=1) max=1;
        if(min<=1) min=1;
        int[] answer = {7-max,7-min};
        return answer;
    }
}