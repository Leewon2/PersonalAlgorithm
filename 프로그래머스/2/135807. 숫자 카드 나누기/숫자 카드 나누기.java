
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        answer = findGCD(arrayA, arrayB);
        answer = Math.max(answer,findGCD(arrayB,arrayA));
        return answer;
    }
    private static int findGCD(int[] array1, int[] array2){
        int gcd = array1[0];
        for(int i=1; i<array1.length; i++){
            gcd = GCD(gcd,array1[i]);
        }
        for(int i=0; i<array2.length; i++){
            if(array2[i]%gcd==0) return 0;
        }
        return gcd;
    }
    
    // 1. arrayA에서 최대공약수 구하기
    
    private static int GCD(int x, int y){
        if(x%y==0) return y;
        return GCD(y, x%y);
    }
}