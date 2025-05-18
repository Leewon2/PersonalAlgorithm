import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> list = new ArrayList<>();
        for(int[] i : intervals){
            for(int j=i[0]; j<=i[1]; j++){
                list.add(arr[j]);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}