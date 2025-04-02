import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        int[] Xarr = makeArr(X);
        int[] Yarr = makeArr(Y);
        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--){
            for(int j=0; j<Math.min(Xarr[i],Yarr[i]); j++) sb.append(i);
        }
        if(sb.toString().equals("")) return "-1";
        else if(sb.toString().charAt(0)=='0') return "0";
        return sb.toString();
    }
    private int[] makeArr(String str){
        int[] arr = new int[10];
        for(int i=0; i<str.length(); i++){
            arr[Character.getNumericValue(str.charAt(i))]++;
        }
        return arr;
    }
}