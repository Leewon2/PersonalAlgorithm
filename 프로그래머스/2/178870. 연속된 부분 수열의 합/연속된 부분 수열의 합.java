class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int sum=0;
        int f=0;
        int l=0;
        boolean check = false;
        for(int i=0; i<sequence.length; i++){
            sum+=sequence[i];
            l=i;
            while(sum>k && f<l){
                sum-=sequence[f++];
            }
            if(sum==k){
                if(check && answer[1]-answer[0]>l-f){
                    answer[0]=f;
                    answer[1]=l;
                }else if(!check){
                    check = true;
                    answer[0]=f;
                    answer[1]=l;
                }
            }
            
        }
        return answer;
    }
}