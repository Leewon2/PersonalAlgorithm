import java.util.*;
class Solution {
            public int solution(int n, int m, int[][] timetable) {
        // 겹치는 숫자가 절반 초과면 무조건 1
        // 절반을 초과하지 않으면 최대 2의 거리가 나온다.
        // 시작을 n*2 -2 로 설정하고, 첫번째부터, list에 선택된 좌표를 담는다.
        // list에 담긴 거리와 비교하고, 거리가 되면 list에 또 담는다.
        int size =calculateSize(timetable,m);
        if(size<=1)
            return 0;
//        else if(size>(n*n)/2) return 1;
        int c = n*2-2;
        while(c>1){
            for(int start = 0; start<n; start++){
                for(int end =0; end<n; end++){
                    List<Node> list = new ArrayList<>();
                    boolean[][] visited = new boolean[n][n];
                    visited[start][end]=true;
                    list.add(new Node(start,end));
                    for(int i=0; i<n; i++){
                        for(int j=0; j<n; j++){
                            // 방문하지 않았으면 각각의 거리를 계산하여 c보다 크거나 같으면 통과
                            if(!visited[i][j]){
                                boolean check = true;
                                for(int k=0; k<list.size(); k++){
                                    if(calculateDist(i,j,list.get(k))<c) {
                                        check=false;
                                        break;
                                    }
                                }
                                if(check){
                                    list.add(new Node(i,j));
                                }
                            }
                        }
                    }
                    if(list.size()>=size) return c;
                }
            }
            c--;
        }



        return c;
    }
    
    private static int calculateDist(int i, int j, Node right){
        return Math.abs(i-right.r)+Math.abs(j-right.c);
    }


    private static int calculateSize(int[][] timetable,int m){
        int[] preSum = new int[1722];

        //1. 가장 많이 겹치는 회원수 구하기
        for (int i = 0; i < m; i++) {
            preSum[timetable[i][0] - 600]++;
            preSum[timetable[i][1] - 600 + 1]--;
        }

        int sum = 0;
        int max = 0; //가장 많이 겹치는 회원 수
        for (int i = 0; i <= 720; i++) {
            sum += preSum[i];
            preSum[i] = sum;
            max = Math.max(max, preSum[i]);
        }
        return max;
//         int cnt=1;
//         Arrays.sort(timetable,(o1, o2)->{
//             if(o1[1]==o2[1]){
//                 return o1[0]-o2[0];
//             }else{
//                 return o1[1]-o2[1];
//             }
//         });
        
//         Queue<Table> q = new ArrayDeque<>();
//         q.offer(new Table(timetable[0][0],timetable[0][1]));
//         for(int i=1; i<m; i++){
//             Table table = q.peek();
//             // 겹치는 시간 계산
//             if(table.e>=timetable[i][0]) q.offer(new Table(timetable[i][0],timetable[i][1]));
//             else{
//                 while(!q.isEmpty()){
//                     Table peekTable = q.peek();
//                     if(peekTable.e>=timetable[i][0]) {
//                         q.offer(new Table(timetable[i][0],timetable[i][1]));
//                         break;
//                     }
//                     else q.poll();
//                 }
//                 if(q.isEmpty()){
//                     q.offer(new Table(timetable[i][0],timetable[i][1]));
//                 }
//             }
//             cnt = Math.max(cnt, q.size());
//         }
//         return cnt;
    }
    private static class Table{
        int s;
        int e;
        public Table(int s, int e){
            this.s=s;
            this.e=e;
        }
    }

    private static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
}