import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int s=-1;
        int e=-1;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==2 && s==-1) {
                s=i;
                e=i;
            }
            else if(arr[i]==2) e=i;
        }
        if(e==-1) list.add(-1);
        for(int i=s; i<=e; i++){
            if(i<0) break;
            list.add(arr[i]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}