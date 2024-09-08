import java.util.*;
class Solution {
    static boolean[] use;
    static List<String> list;
    public String[] solution(String[][] tickets) {
        
        list = new ArrayList<>();
        use = new boolean[tickets.length];
        dfs(0,"ICN","ICN",tickets);
        Collections.sort(list);
        return list.get(0).split(" ");
    }
    
    private static void dfs(int idx, String start, String route, String[][] tickets){
        if(idx==tickets.length){
            list.add(route);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(!use[i] && tickets[i][0].equals(start)){
                use[i]=true;
                dfs(idx+1, tickets[i][1], route+ " " + tickets[i][1], tickets);
                use[i]=false;
            }
        }
    }
}