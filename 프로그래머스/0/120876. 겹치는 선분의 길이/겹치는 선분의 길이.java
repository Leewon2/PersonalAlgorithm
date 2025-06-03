import java.util.*;
class Solution {
    public int solution(int[][] lines) {
        boolean[] visited = new boolean[201];
        boolean[] visited2 = new boolean[201];
        int answer = 0;
        makeTrue(lines[0],visited);
        overlap(lines[1], visited, visited2);
        overlap(lines[2], visited, visited2);
        visited = new boolean[201];
        makeTrue(lines[1],visited);
        overlap(lines[2], visited, visited2);
        for(boolean b : visited2){
            if(b) answer++;
        }
        return answer;

    }
    private void overlap(int[] x, boolean[] visited, boolean[] visited2){
        for(int i=x[0]+100; i<x[1]+100; i++){
            if(visited[i]) visited2[i] = true;
        }
    }
    
    private void makeTrue(int[] x, boolean[] visited){
        for(int i=x[0]+100; i<x[1]+100; i++){
            visited[i]=true;
        }
    }

}