import java.util.*;
class Solution {
    boolean[] delete;
    public String solution(int n, int k, String[] cmd) {
        delete = new boolean[n];
        // 삭제된 행 담기
        int[] pre = new int[n];
        int[] next = new int[n];
        for(int i=0; i<n; i++){
            pre[i]=i-1;
            next[i]=i+1;
        }
        next[n-1]=-1;
        Stack<Node> stack = new Stack<>();
        for(int i=0; i<cmd.length; i++){
            if(cmd[i].equals("C")){
                delete[k]=true;
                // pre, next 정보 넣기
                stack.push(new Node(pre[k],k,next[k]));
                // pre와 next값 이동 => 2를 삭제한 경우, 1에 있던 next 값이 2에서 3으로 변경
                if(pre[k] != -1) next[pre[k]]=next[k];
                if(next[k] != -1) pre[next[k]]=pre[k];
                // 끝점이 아닌 경우, 다음 값으로 이동
                if(next[k]!=-1) k = next[k];
                // 끝점인 경우 이전 값으로 이동
                else k=pre[k];
            }else if(cmd[i].equals("Z")){
                Node pop = stack.pop();
                // 원상복구
                delete[pop.c]=false;
                // 복구했으니, 다음에 있던 값을 현재로 바꿈
                if(pop.p != -1) next[pop.p] = pop.c;
                if(pop.ne != -1) pre[pop.ne] = pop.c;
            }else{
                String[] str= cmd[i].split(" ");
                int x = Integer.parseInt(str[1]);
                int index=0;
                if(str[0].equals("U")){
                    while(x>0){
                        k=pre[k];
                        x--;
                    }
                }else{
                    while(x>0){
                        k=next[k];
                        x--;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            if(delete[i]) sb.append("X");
            else sb.append("O");
        }
        return sb.toString();
    }
    class Node{
        int p,c,ne;
        public Node(int p, int c, int ne){
            this.p=p;
            this.c=c;
            this.ne=ne;
        }
    }
    
}