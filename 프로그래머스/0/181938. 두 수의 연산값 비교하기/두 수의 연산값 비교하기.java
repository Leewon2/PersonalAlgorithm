class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String str="";
        int x = Integer.parseInt(str+a+b);
        int y = 2*a*b;
        return Math.max(x,y);
    }
}