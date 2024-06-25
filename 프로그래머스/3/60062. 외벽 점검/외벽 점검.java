import java.util.*;

class Solution {
    static boolean[] visit;
    static int answer;
    static int[] arr;
    static boolean over;
    public int solution(int n, int[] weak, int[] dist) {
        answer=0;
        visit = new boolean[dist.length];
        over = false;
        for(int i=1; i<=dist.length; i++){
            if(!over){
                arr = new int[i];
                perm(0,i,dist,weak, n);
            }
        }
        if(answer ==0) answer = -1;
        return answer;
    }
    
    private static void perm(int idx, int cnt, int[] dist, int[] weak, int n){
        if(over) return;
        
        if(idx==cnt){
            // start point는 weak의 0번째부터 한다.
            // 그 다음 dist의 배열은 weak에서 사용되지 않은 가장 가까운 녀석으로 한다.
            for(int i=0; i<weak.length; i++){
                int count=0;
                int next=i;
                boolean[] use = new boolean[weak.length];
                for(int j=0; j<arr.length; j++){
                    int d = arr[j];
                    int tmp = weak[next]+d;
                    int subTmp = -1;
                    if(tmp>=n){
                        subTmp = tmp%n;
                    }
                    
                    for(int k=i; k<weak.length; k++){
                        if(use[k]) continue;
                        if(weak[k]<=tmp){
                            count++;
                            next=(k+1)%weak.length;
                            use[k] = true;
                        }
                    }
                    for(int k=0; k<weak.length; k++){
                        if(use[k]) continue;
                        if(weak[k]<=subTmp){
                            count++;
                            next=(k+1)%weak.length;
                            use[k] = true;
                        }
                    }
                    if(count>=weak.length){
                        answer = cnt;
                        over = true;
                        return;
                    }
                }
            }
            return;
        }
        for(int i=0; i<dist.length; i++){
            if(visit[i]) continue;
            arr[idx] = dist[i];
            visit[i] = true;
            perm(idx+1, cnt, dist,weak,n);
            visit[i] = false;
            
        }
    }
    
}