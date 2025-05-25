class Solution {
    public int[][] solution(int[][] arr) {
        int x= arr.length;
        int y= arr[0].length;
        int max = Math.max(x,y);
        int[][] answer = new int[max][max];
        for(int r=0; r<max; r++){
            for(int c=0; c<max; c++){
                if(r>=x || c>=y) answer[r][c]=0;
                else answer[r][c] = arr[r][c];
            }
        }
        return answer;
    }
}