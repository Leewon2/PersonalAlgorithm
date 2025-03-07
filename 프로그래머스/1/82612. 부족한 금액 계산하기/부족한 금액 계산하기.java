class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        while(count>0){
            answer+=(price*count);
            count--;
        }

        return money-answer >=0 ? 0 : answer-money;
    }
}