import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = new ArrayList<>();
        boolean[] delete = new boolean[1001];
        for(int i=0; i<delete_list.length; i++){
            delete[delete_list[i]] = true;
        }
        for(int i=0; i<arr.length;i++){
            if(!delete[arr[i]]) list.add(arr[i]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}