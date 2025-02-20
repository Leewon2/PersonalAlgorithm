import java.util.*;
class Solution {
    // 동서남북
    char[] dir = {'E','W','S','N'};
    int[] dr = {0,0,1,-1};
    int[] dc = {1,-1,0,0};
    public int[] solution(String[] park, String[] routes) {
        int r=0;
        int c=0;
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[0].length(); j++){
                if(park[i].charAt(j)=='S'){
                    r=i;
                    c=j;
                }
            }
        }
        
        for(int i=0; i<routes.length; i++){
            int d=0;
            String[] arr = routes[i].split(" ");
            for(int j=0; j<4; j++){
                if(arr[0].charAt(0)==dir[j]){
                    d=j;
                    break;
                }
            }
            int dist = Character.getNumericValue(arr[1].charAt(0));
            int nr =r;
            int nc=c;
            while(dist>0){
                nr+=dr[d];
                nc+=dc[d];
                if(nr<0 || nc<0 || nr>=park.length || nc>=park[0].length()) break;
                if(park[nr].charAt(nc)=='X') break;
                dist--;
            }
            if(dist==0){
                r=nr;
                c=nc;
            }
            
        }
        int[] answer = {r,c};
        return answer;
    }
}