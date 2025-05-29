class Solution {
    boolean[] arr;
    public int solution(int[] nums) {
        arr = new boolean[500001];
        makesosu();
        int answer = 0;
        
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    if(!arr[sum]) answer++;
                }
            }
        }
        return answer;
    }
    private void makesosu(){
        for(int i=2; i*i<=500000; i++){
            if(arr[i]) continue;
            for(int j=i*i; j<=500000; j+=i){
                arr[j] = true;
            }
        }
    }
    
}