import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] e = new int[elements.length*2];
        for(int i=0; i<elements.length; i++){
            e[i] = elements[i];
            e[elements.length+i] = elements[i];
        }
        for(int i=1; i<=elements.length; i++){
            for(int j=0; j<elements.length; j++){
                int sum=0;
                for(int k=j; k<j+i; k++){
                    sum+=e[k];
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}