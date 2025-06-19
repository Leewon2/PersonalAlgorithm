import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        int answer = -1;
        
        for(int i=mats.length-1; i>=0; i--){
            int n = mats[i];
            answer = Math.max(answer, checkPark(park, n));
        }
        return answer;
    }
    private int checkPark(String[][] park, int n){
        int max = -1;
        for(int r=0; r<park.length; r++){
            for(int c=0; c<park[0].length; c++){
                if(park[r][c].equals("-1")){
                    max = Math.max(max, canSpread(n,park, r, c));
                }
            }
        }
        return max;
    }
    
    private int canSpread(int n, String[][] park, int r, int c){
        if(r+n>park.length || c+n>park[0].length) return -1;
        for(int i=r; i<n+r; i++){
            for(int j=c; j<n+c; j++){
                if(!park[i][j].equals("-1")) return -1;
            }
        }
        return n;
    }
}