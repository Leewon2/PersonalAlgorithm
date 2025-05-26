class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int x=0;
        int y=0;
        while(n>=a){
            x=n/a*b;
            y=n%a;
            answer+=x;
            n=x+y;
        }
        return answer;
    }
}