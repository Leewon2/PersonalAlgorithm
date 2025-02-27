class Solution {
    public int solution(int a, int b) {
        String aa = Integer.toString(a);
        String bb = Integer.toString(b);
        String  left = aa+bb;
        String right = bb+aa;
        return Math.max(Integer.parseInt(left),Integer.parseInt(right));
    }
}