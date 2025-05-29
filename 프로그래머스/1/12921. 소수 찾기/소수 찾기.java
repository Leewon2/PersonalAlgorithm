class Solution {
    boolean[] arr;
    public int solution(int n) {
        arr = new boolean[1000001];
        makesosu();
        int answer = 0;
        for(int i=2; i<=n; i++){
            if(!arr[i]) answer++;
        }
        
        return answer;
    }
    private void makesosu(){
        for(int i=2; i*i<=1000000; i++){
            if(arr[i]) continue;
            for(int j=i*i; j<=1000000; j+=i){
                arr[j]=true;
            }
        }
    }
    
}