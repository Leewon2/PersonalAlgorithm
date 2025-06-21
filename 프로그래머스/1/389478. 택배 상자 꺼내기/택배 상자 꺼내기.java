import java.util.*;
class Solution {
    // 우 아래 왼 아래
    int[] dr = {0,1,0,1};
    int[] dc = {1,0,-1,0};
    public int solution(int n, int w, int num) {
        int answer = 0;
        int r= n%w==0 ? n/w : n/w+1;
        int[][] arr = new int[r][w];
        int d = 0;
        int nowR = 0;
        int nowC = 0;
        int idx=1;
        while(idx<=n){
            arr[nowR][nowC] = idx;
            idx++;
            if(d%2==1) d++;
            int nr = nowR+dr[d%4];
            int nc = nowC+dc[d%4];
            if(nr<0 || nc<0 || nr>=r || nc>=w){
                d++;
            }
            nowR += dr[d%4];
            nowC += dc[d%4];
        }
        int sr=0;
        int sc=0;
        outer : for(int i=0; i<r; i++){
            for(int j=0; j<w; j++){
                if(arr[i][j]==num){
                    sr=i;
                    sc=j;
                    break outer;
                }
            }
        }
        while(sr<r){
            if(arr[sr][sc]==0) break;
            answer++;
            sr++;
        }

        return answer;
    }
}