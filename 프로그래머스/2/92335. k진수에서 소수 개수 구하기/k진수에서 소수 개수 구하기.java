class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String str = Integer.toString(n,k)+"0";
        String now = "";
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='0' && !now.equals("")){
                long num = Long.parseLong(now);
                if(isPrime(num)) answer++;
                now = "";
            }else if(str.charAt(i)!='0'){
                now+=str.charAt(i);
            }
        }
        return answer;
    }
    private boolean isPrime(long k){
        if(k<2) return false;
        for(int i=2; i<=Math.sqrt(k); i++){
            if(k%i==0) return false;
        }
        return true;
    }
}