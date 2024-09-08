import java.util.*;
class Solution {
    static boolean[] visited;
    static int[][] dp;
    static List<List<Integer>> list;
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        for(int[] l : lighthouse){
            list.get(l[0]).add(l[1]);
            list.get(l[1]).add(l[0]);
        }
        
        visited = new boolean[n+1];
        dp = new int[n+1][2];
        dfs(1);
        answer = Math.min(dp[1][0],dp[1][1]);
        return answer;
    }
    private static void dfs(int now){
        visited[now] = true;
        dp[now][0]=0;
        dp[now][1]=1;
        for(int i=0; i<list.get(now).size(); i++){
            int next = list.get(now).get(i);
            if(visited[next]) continue;
            dfs(next);
            dp[now][0]+=dp[next][1];
            dp[now][1]+=Math.min(dp[next][0],dp[next][1]);
        }
    }
}