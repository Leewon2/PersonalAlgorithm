class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        long nn = n;
        long cnt = factorial(nn);
        boolean[] use = new boolean[n+1];
        int idx=1;
        for(int i=0; i<n; i++){
            for(int j=1; j<=n; j++){
                if(!use[j]){
                    idx = j;
                    break;
                }
            }
            cnt/=(nn--);
            while(cnt<k){
                for(int c = idx+1; c<=n; c++){
                    if(!use[c]){
                        idx=c;
                        break;
                    }
                }
                k-=cnt;
            }
            answer[i]=idx;
            use[idx]=true;
        }
        return answer;
    }
    
    private long factorial(long k){
        long sum=1;
        for(int i=1; i<=k; i++){
            sum*=i;
        }
        return sum;
            
    }
}