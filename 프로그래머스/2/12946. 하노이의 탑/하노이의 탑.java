import java.util.*;
class Solution {
    List<int[]> list;
    public int[][] solution(int n) {
        list = new ArrayList<>();
        dfs(n, 1,2,3);
        
        int[][] answer = new int[list.size()][2];
        
        for(int i=0; i<list.size(); i++){
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }
        return answer;
    }
    
    private void dfs(int n, int s, int m, int e){
        int[] arr = {s,e};
        if(n==1) {
            list.add(arr);
            return;
        }
        dfs(n-1, s, e, m);
        list.add(arr);
        dfs(n-1, m, s, e);
    }
}