class Solution {
    int[] arr;
    int customer;
    int sales;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        arr = new int[emoticons.length];
        customer=0;
        sales=0;
        perm(emoticons, 0, users);
        return new int[]{customer,sales};
    }
    
    public void perm(int[] emoticons, int idx, int[][] users){
        if(idx==emoticons.length){
            calculate(emoticons, users);
            return;
        }
        for(int i=1; i<=4; i++){
            arr[idx]=i;
            perm(emoticons, idx+1, users);
        }
    }
    
    public void calculate(int[] emoticons, int[][] users){
        int c=0;
        int s=0;
        for(int[] i : users){
            int percent = i[0];
            int price = i[1];
            int sum=0;
            for(int j=0; j<emoticons.length; j++){
                if(arr[j]*10>=percent){
                    sum+=(emoticons[j]-emoticons[j]*arr[j]/10);
                }
            }
            if(sum>=price) c++;
            else s+=sum;
        }
        if(customer<c) {
            customer=c;
            sales = s;
        }
        else if(customer==c){
            sales = Math.max(sales,s);
        }
    }
}