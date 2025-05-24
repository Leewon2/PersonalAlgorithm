class Solution {
    public int solution(int[] arr) {
        int[] arr2 = arr.clone();
        int answer = 0;
        while(true){
            for(int i=0; i<arr.length; i++){
                if(arr[i]>=50 && arr[i]%2==0){
                    arr2[i]/=2;
                }else if(arr[i]<50 && arr[i]%2==1){
                    arr2[i]*=2;
                    arr2[i]++;
                }
            }
            boolean check = true;
            for(int i=0; i<arr.length; i++){
                if(arr[i]!=arr2[i]){
                    check=false;
                    break;
                }
            }
            if(check) break;
            
            answer++;
            arr= arr2.clone();
        }
            
        return answer;
    }
}