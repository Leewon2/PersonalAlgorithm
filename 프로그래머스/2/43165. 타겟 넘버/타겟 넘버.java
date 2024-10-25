class Solution {
    int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(0,0,numbers,target);
        return answer;
    }
    
    private void dfs(int k, int idx, int[] numbers, int target){
        if(idx==numbers.length){
            if(k==target) answer++;
            return;
        }
        dfs(k-numbers[idx], idx+1, numbers, target);
        dfs(k+numbers[idx], idx+1, numbers, target);
    }
}