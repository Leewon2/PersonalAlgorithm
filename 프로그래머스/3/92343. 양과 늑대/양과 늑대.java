class Solution {
    int answer;
    public int solution(int[] info, int[][] edges) {
        answer = 0;
        boolean[] visited = new boolean[info.length];
        dfs(0,0,0,info,edges, visited);
        return answer;
    }
    
    private void dfs(int idx, int sCnt, int wCnt, int[] info, int[][] edges, boolean[] visited){
        visited[idx] = true;
        if(info[idx]==0){
            sCnt++;
            answer = Math.max(sCnt, answer);
        }else{
            wCnt++;
            if(sCnt<=wCnt) return;
        }
        for(int[] edge : edges){
            if(visited[edge[0]] && !visited[edge[1]]){
                boolean[] otherVisited = visited.clone();
                dfs(edge[1], sCnt, wCnt, info, edges, otherVisited);
            }
        }
    }
    
}