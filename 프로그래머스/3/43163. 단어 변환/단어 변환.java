import java.util.*;

class Solution {
    static int min;
    public int solution(String begin, String target, String[] words) {
        boolean check = false;
        for(int i=0; i<words.length; i++){
            if(words[i].equals(target)) check=true;
        }
        if(!check || begin.length()!=target.length()) return 0;
        min=Integer.MAX_VALUE;
        boolean[] visited = new boolean[words.length];
        DFS(begin,0,words,visited,target);
  
        
        return min;
    }
    private static void DFS(String w, int d,String[] words, boolean[] visited, String target){
        if(w.equals(target)){
            min = Math.min(min,d);
            return;
        }
        for(int i=0; i<words.length; i++){
            if(visited[i]) continue;
            int cnt=0;
            for(int j=0; j<w.length(); j++){
                if(w.charAt(j)!=words[i].charAt(j)) cnt++;
            }
            if(cnt==1){
                visited[i] = true;
                DFS(words[i],d+1,words,visited, target);
                visited[i] = false;
            }
        }
    }
    
    
    private static class Node{
        String w;
        int d;
        public Node(String w, int d){
            this.w=w;
            this.d=d;
        }
    }
}