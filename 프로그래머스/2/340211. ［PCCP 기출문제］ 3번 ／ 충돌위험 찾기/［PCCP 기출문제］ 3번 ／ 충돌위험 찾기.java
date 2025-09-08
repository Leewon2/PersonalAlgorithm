import java.util.*;
class Solution {
    Map<Node, List<Integer>> map;
    boolean[][] arr;
    public int solution(int[][] points, int[][] routes) {
        map = new HashMap<>();
        arr = new boolean[101][101];
        int answer = 0;
        // 최단 경로를 구하는 과정에서, r과의 차이, 그 다음 c와의 차이를 구하면 될듯?
        for(int i=0; i<routes.length; i++){
            int idx=0;
            int s = routes[i][0]-1;
            int sr = points[s][0]; int sc = points[s][1];
            calculate(sr,sc, idx);
            for(int j=0; j<routes[i].length-1; j++){
                int start = routes[i][j]-1; int end = routes[i][j+1]-1;
                int startR = points[start][0]; int startC = points[start][1];
                int endR = points[end][0]; int endC = points[end][1];
                
                if(startR<endR){
                    while(startR<endR){
                        idx++; startR++;
                        calculate(startR,startC, idx);
                    }
                }else{
                    while(startR>endR){
                        idx++; startR--;
                        calculate(startR,startC, idx);
                    }
                }
                if(startC<endC){
                    while(startC<endC){
                        idx++; startC++;
                        calculate(startR,startC, idx);
                    }
                }else{
                    while(startC>endC){
                        idx++; startC--;
                        calculate(startR,startC, idx);
                    }
                }
            }
        }

        for (List<Integer> times : map.values()) {
            Collections.sort(times); 
            int i = 0;
            while (i < times.size()) {
                int t = times.get(i);
                int j = i + 1;
                while (j < times.size() && times.get(j) == t) j++;
                if (j - i >= 2) answer++;
                i = j;
            }
        }
        return answer;
    }
    
    private void calculate(int r, int c, int idx){
        Node node = new Node(r,c);
        if(map.get(node)==null){
            List<Integer> list = new ArrayList<>();
            list.add(idx);
            map.put(node, list);
        }
        else{
            List<Integer> list = map.get(node);
            list.add(idx);
            map.put(node, list);
        }
    }
    
    private class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r=r;
            this.c=c;
        }
        @Override
        public boolean equals(Object o){
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node that = (Node) o;
            return this.r == that.r && this.c == that.c;
        }
        @Override
        public int hashCode(){
            return Objects.hash(r, c);
        }
    }
}