class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        // stations에 있는 친구 - W를 한다. 1부터 시작해서
        // 해당 위치까지 몇개인지 계산한다.
        // stations의 마지막 + W가 끝이 아니면 마지막은 끝을 기준으로 계산한다.
        int now = 0;
        int left = 0;
        int right = 0;
        int len = w*2+1;
        for(int i=0; i<stations.length; i++){
            left = stations[i]-w;
            right = stations[i]+w;
            if(left<=0 || now>=left) now = right;
            else{
                int cnt = (left - now -1 )%len==0 ? (left-now-1)/len : (left-now-1)/len+1;
                answer += cnt;
                now = right;
            }
        }
        if(right<n){
            // System.out.println(right);
            int cnt = (n - now)%len==0 ? (n-now)/len : (n-now)/len+1;
            answer += cnt;
        }

        return answer;
    }
}