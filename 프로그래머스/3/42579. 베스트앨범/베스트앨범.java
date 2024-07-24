import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Queue<Integer> q = new LinkedList<>();
        Map<String,Node> map = new HashMap<>();
        Map<String,Boolean> use = new HashMap<>();
        int cnt=0;
        for(int i=0; i<genres.length; i++){
            Playing newPlaying = new Playing(plays[i],i);
            if(map.get(genres[i])==null){
                use.put(genres[i],false);
                List<Playing> l = new ArrayList<>();
                l.add(newPlaying);
                map.put(genres[i], new Node(plays[i],l));
            }else{
                if(!use.get(genres[i])){
                    cnt+=2;
                    use.put(genres[i],true);
                }
                
                List<Playing> l = map.get(genres[i]).list;
                l.add(newPlaying);
                int pc = map.get(genres[i]).pCnt;
                map.put(genres[i], new Node(pc+plays[i],l));
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{
            return o2.pCnt-o1.pCnt;
        });
        for(String k : map.keySet()){
            pq.offer(map.get(k));
        }
        if(pq.size() != cnt/2){
            cnt+=(pq.size()-cnt/2);
        }
        int idx=0;
        int[] answer = new int[cnt];
        PriorityQueue<Playing> playPq = new PriorityQueue<>((o1,o2)->{
            if(o1.playCnt!=o2.playCnt){
                return o2.playCnt-o1.playCnt;
            }
            return o1.idx-o2.idx;
        });
        
        while(!pq.isEmpty()){
            Node poll = pq.poll();
            for(int i=0; i<poll.list.size(); i++){
                playPq.offer(poll.list.get(i));
            }
            int id=0;
            while(!playPq.isEmpty()){
                Playing p = playPq.poll();
                answer[idx++] = p.idx;
                id++;
                if(id==2) break;
            }
            playPq.clear();
        }
 
        
        return answer;
    }
    
    private static class Node{
        int pCnt;
        List<Playing> list;

        public Node(int pCnt, List<Playing> list){
            this.pCnt=pCnt;
            this.list = list;
        }
    }
    private static class Playing{
        int playCnt;
        int idx;
        public Playing(int playCnt, int idx){
            this.playCnt=playCnt;
            this.idx=idx;
        }
    }
    
    
}