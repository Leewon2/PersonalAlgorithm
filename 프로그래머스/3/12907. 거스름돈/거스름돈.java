class Solution {
    public int solution(int n, int[] money) {
        int[] ans = new int[100001];
        for(int i=0; i<=n; i++){
            if(i%money[0]==0) ans[i]=1;
        }
        for(int i=1; i<money.length; i++){
            for(int j=money[i]; j<=n; j++){
                ans[j] = (ans[j]+ ans[j-money[i]])%1000000007;
            }
        }
        
        return ans[n];
    }
}