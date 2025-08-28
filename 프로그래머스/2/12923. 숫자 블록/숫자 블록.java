class Solution {
    public int[] solution(long begin, long end) {
        int s = (int) begin;
        int e = (int) end;
        int[] answer = new int[e-s+1];
        // 약수 중 자기 자신을 제외하고 가장 큰 수
        int idx=0;
        for(int i=s; i<=e; i++){
            if(i==1) {
                answer[idx++]=0;
                continue;
            }
            int max=1;
            for(int j=2; j*j<=i; j++){
                if(i%j==0){
                    max=Math.max(max,j);
                    if(j != i/j && i/j<=10000000){
                        max=Math.max(max,i/j);
                    }
                }
            }
            answer[idx++] = max;
        }
        return answer;
    }
}