class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        if(a==b && a==c){
            answer = calculate(a,b,c,1)*calculate(a,b,c,2)*calculate(a,b,c,3);
        }else if(a==b || a==c || b==c){
            answer = calculate(a,b,c,1)*calculate(a,b,c,2);
        }else{
            answer=a+b+c;
        }
        return answer;
    }
    private int calculate(int a, int b, int c, int exp){
        return (int) Math.pow(a,exp) + (int) Math.pow(b,exp) + (int) Math.pow(c,exp); 
    }
}