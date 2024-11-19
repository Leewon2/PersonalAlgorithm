class Solution {
    char[][] arr;
    char[][] boards;
    public int solution(int m, int n, String[] board) {
        boards = new char[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                boards[i][j] = board[i].charAt(j);
            }
        }
        arr = new char[m][n];
        while(move(m,n));
        int answer = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(boards[i][j]=='0') answer++;
            }
        }
        return answer;
    }
    private boolean move(int m, int n){
        boolean check = false;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = boards[i][j];
            }
        }
        for(int i=0; i<m-1; i++){
            for(int j=0; j<n-1; j++){
                char compare = boards[i][j];
                if(compare=='0'||boards[i+1][j]!=compare || boards[i+1][j+1]!=compare || boards[i][j+1]!=compare) continue;
                arr[i][j] = '0';
                arr[i+1][j] = '0';
                arr[i][j+1] = '0';
                arr[i+1][j+1] = '0';
                check = true;
            }
        }
        if(!check) return false;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                boards[i][j]=arr[i][j];
            }
        }
        
        for(int i=0; i<n; i++){
            int idx=-1;
            boolean b = false;
            for(int j=m-1; j>=0; j--){
                if(boards[j][i]=='0'){
                    idx = j;
                    int k = idx-1;
                    while(k>=0){
                        if(boards[k][i]!='0'){
                            boards[idx][i] = boards[k][i];
                            boards[k][i]='0';
                            break;
                        }
                        k--;
                    }
                }
            }
        }
        
        return true;
    }
    
}