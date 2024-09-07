class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 0;
        int max = 200000000;
        while(min<=max){
            int mid = (min+max)/2;
            int cnt=0;
            boolean check = true;
            for(int s : stones){
                if(s-mid<0) cnt++;
                else cnt=0;
                if(cnt==k) check=false;
            }
            if(check){
                answer = Math.max(answer,mid);
                min = mid+1;
            }else{
                max = mid-1;
            }
        }
        
        return answer;
    }
}