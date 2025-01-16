import java.util.*;
class Solution {
    int[] arr;
    List<List<Integer>> list;
    boolean[] use;
    public int solution(int n, int[][] wires) {
        arr = new int[n+1];
        int answer=Integer.MAX_VALUE;
        for(int j=0; j<wires.length; j++){
            list = new ArrayList<>();
            for(int i=0; i<=n; i++){
                list.add(new ArrayList<>());
            }
            for(int i=0; i<wires.length; i++){
                if(i==j) continue;
                list.get(wires[i][1]).add(wires[i][0]);
                list.get(wires[i][0]).add(wires[i][1]);
                // System.out.println("a : "+wires[i][0]+" b : "+wires[i][1]);
            }
            use = new boolean[n+1];
            use[1]=true;
            int res = dfs(1,1);
            int re = n-res;
            answer = Math.min(answer,Math.abs(res-re));
        }

        return answer;
    }
    private int dfs(int parent, int cnt){
        for(int i=0; i<list.get(parent).size(); i++){
            int k = list.get(parent).get(i);
            // System.out.println("k : "+k);
            if(!use[k]) {
                use[k] = true;
                cnt = dfs(k, cnt + 1);
            }
        }
        return cnt;
    }
}