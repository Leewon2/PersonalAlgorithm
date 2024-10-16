class Solution {
    public int[] solution(int n, long left, long right) {
        long len = right-left+1;
        int[] answer = new int[(int) len];
        int idx=0;
        for(long i=left+1; i<=right+1; i++){
            long a = (i%n==0) ? (i/n) : (i/n +1);
            long b = (i-1)%n+1;
            if(b<=a){
                answer[idx++] = (int) a;
            }else{
                answer[idx++] = (int) b;
            }
        }
        
        return answer;
    }
}