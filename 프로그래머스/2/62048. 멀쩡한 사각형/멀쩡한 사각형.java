class Solution {
    public long solution(int w, int h) {
        long answer = (long)w*(long)h-((long) w + (long) h);
        
        return answer+gcd(w,h);
    }
    
    private long gcd(int x, int y){
        if(y==0) return x;
        return gcd(y, x%y);
    }
}