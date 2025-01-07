class Solution {
    int[] answer;
    
    public int[] solution(int[][] arr) {
        answer = new int[2];
        dfs(arr,0,0,arr[0][0],arr.length);
        return answer;
    }
    
    public void dfs(int[][] arr, int r, int c, int now, int size){
        if(size==1){
            answer[now]++;
            return;
        }
        boolean check = true;
        outer : for(int i=r; i<r+size; i++){
            for(int j=c; j<c+size; j++){
                if(arr[i][j]!=now) {
                    check= false;
                    break outer;
                }
            }
        }
        if(check){
            answer[now] ++;
            return;
        }else{
            dfs(arr, r, c, arr[r][c], size/2);
            dfs(arr, r+size/2, c, arr[r+size/2][c], size/2);
            dfs(arr, r, c+size/2, arr[r][c+size/2], size/2);
            dfs(arr, r+size/2, c+size/2, arr[r+size/2][c+size/2], size/2);
        }
    }
}