class Solution {
    final int[] month = {31,29,31,30,31,30,31,31,30,31,30,31};
    final String[] date = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
    public String solution(int a, int b) {
        int sum=b;
        for(int i=0; i<a-1; i++){
            sum+=month[i];
        }
        return date[sum%7];
    }
}