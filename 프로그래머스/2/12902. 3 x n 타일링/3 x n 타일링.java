class Solution {
    public int solution(int n) {
        if(n%2==1) return 0;
        long[] arr = new long[n+1];
        int mod=1000000007;
        arr[2]=3;
        arr[4]=11;
       for(int i=6; i<=n; i+=2){
           arr[i]= (arr[i-2]*4%mod -arr[i-4]%mod +mod)%mod;
        };
        
        return (int)arr[n];
    }
    
  
}