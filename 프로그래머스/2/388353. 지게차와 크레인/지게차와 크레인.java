import java.util.*;
class Solution {
    int row;
    int col;
    int[] dr={1,0,-1,0};
    int[] dc={0,1,0,-1};
    boolean[][] visited;
    char[][] arr;
    char[][] subArr;
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        // 출고 요청이 들어온 순간 접근 가능한 컨테이너만 꺼낸다
        row = storage.length; col = storage[0].length();
        arr = new char[row][col];
        subArr = new char[row][col];
        visited = new boolean[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                arr[i][j]= storage[i].charAt(j);
                subArr[i][j]= storage[i].charAt(j);
            }
        }
        for(String s : requests){
            if(s.length()>1){
                for(int i=0; i<row; i++){
                    for(int j=0; j<col; j++){
                        if(arr[i][j]==s.charAt(0)){
                            subArr[i][j]='0';
                        }
                    }
                }
                for(int i=0; i<row; i++){
                    arr[i] = subArr[i].clone();
                }
            }else{
                for(int i=0; i<row; i++){
                    for(int j=0; j<col; j++){
                        if(arr[i][j]==s.charAt(0)){
                            visited = new boolean[row][col];
                            visited[i][j]=true;
                            if(canGo(i,j)) {
                                subArr[i][j]='0';
                            }
                        }
                    }
                }
                for(int i=0; i<row; i++){
                    arr[i] = subArr[i].clone();
                }
            }
        }
        
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(arr[i][j]!='0') answer++;
            }
        }
        
        return answer;
    }
    private boolean canGo(int r, int c){
        for(int i=0; i<4; i++){
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(nr<0 || nc<0 || nr>=row || nc>=col) return true;
            if(arr[nr][nc]=='0' && !visited[nr][nc]) {
                visited[nr][nc]=true;
                if(canGo(nr,nc)) return true;;
            }
        }
        return false;
    }
}