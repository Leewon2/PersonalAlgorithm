class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = numbers.clone();
        int idx=0;
        for(long l : numbers){
            answer[idx]++;
            answer[idx] += (answer[idx++] ^ l) >> 2;
        }
        return answer;
    }
}