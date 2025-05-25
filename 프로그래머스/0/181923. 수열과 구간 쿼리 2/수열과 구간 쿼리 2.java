class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for(int i=0; i<queries.length; i++){
            int min = Integer.MAX_VALUE;
            int s = queries[i][0];
            int e = queries[i][1];
            for(int j=s; j<=e; j++){
                if(arr[j]>queries[i][2]){
                    min = Math.min(min,arr[j]);
                }
            }
            if(min==Integer.MAX_VALUE) min = -1;
            answer[i] = min;
            
        }
        return answer;
    }
}