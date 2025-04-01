import java.util.*;
class Solution {
    int[] sArr;
    int[] aArr;
    int[] bArr;
    List<List<Node>> list ;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        list = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<fares.length; i++){
            int c = fares[i][0];
            int d = fares[i][1];
            int f = fares[i][2];
            list.get(c).add(new Node(d,f));
            list.get(d).add(new Node(c,f));
        }
        sArr = new int[n+1];
        aArr = new int[n+1];
        bArr = new int[n+1];
        Arrays.fill(sArr,Integer.MAX_VALUE);
        Arrays.fill(aArr,Integer.MAX_VALUE);
        Arrays.fill(bArr,Integer.MAX_VALUE);
        dijkstra(s,sArr);
        dijkstra(a,aArr);
        dijkstra(b,bArr);
        for(int i=1; i<=n; i++){
            answer = Math.min(answer,sArr[i]+aArr[i]+bArr[i]);
        }
        return answer;
    }
    private void dijkstra(int start, int[] arr){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{
            return o1.total-o2.total;
        });
        pq.offer(new Node(start,0));
        arr[start]=0;
        while(!pq.isEmpty()){
            Node poll = pq.poll();
            if(poll.total > arr[poll.next]) continue;
            for(Node node : list.get(poll.next)){
                int cost = node.total+arr[poll.next];
                if(arr[node.next]>cost){
                    arr[node.next]=cost;
                    pq.offer(node);
                }
            }
        }
        
    }
    
    
    private class Node{
        int next;
        int total;
        public Node(int next, int total){
            this.next=next;
            this.total=total;
        }
    }
}