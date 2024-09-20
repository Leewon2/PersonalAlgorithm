import java.util.*;
class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int answer = arr[arr.length-1];
        for(int i = 0; i < arr.length - 1; i++) {
            int g = gcd(answer,arr[i]);
            answer = (answer*arr[i])/g;
        }
        return answer;
    }
    
    private static int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}
