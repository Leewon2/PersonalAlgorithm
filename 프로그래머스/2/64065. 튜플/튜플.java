import java.util.*;
class Solution {
    public int[] solution(String s) {
        String str = s.substring(2,s.length()-2);
        String[] arr = str.split("\\},\\{");
        String[][] arrr = new String[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            arrr[i] = arr[i].split(",");
        }
        Arrays.sort(arrr, Comparator.comparingInt(a -> a.length));
        int[] answer = new int[arrr[arr.length-1].length];
        int idx=0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arrr[i].length; j++){
                int k = Integer.parseInt(arrr[i][j]);
                if(!set.contains(k)){
                    set.add(k);
                    answer[idx++]=k;
                }
            }
        }
        return answer;
    }
}