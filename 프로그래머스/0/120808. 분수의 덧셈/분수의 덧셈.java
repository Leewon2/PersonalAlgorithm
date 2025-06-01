class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int bunmo = denom1*denom2;
        int bunja = denom2*numer1+denom1*numer2;
        int gcd = gcd(bunmo, bunja);
        return new int[]{bunja/gcd,bunmo/gcd};
    }
    
    private int gcd(int x, int y){
        if(x%y==0)
            return y;
        return gcd(y, x%y);
    }
}