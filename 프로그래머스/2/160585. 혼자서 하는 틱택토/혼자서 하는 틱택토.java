class Solution {
    public int solution(String[] board) {
        int oCnt=0;
        int xCnt=0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length(); j++){
                if(board[i].charAt(j)=='O') oCnt++;
                else if(board[i].charAt(j)=='X') xCnt++;
            }
        }
        if(xCnt>oCnt || oCnt-xCnt>1) return 0;
        // 갯수가 같은데 O가 정답인 경우
        if(xCnt==oCnt){
            if(check(board,'O')) return 0;
        }
        // 갯수가 1개 많은데 X가 정답인 경우
        else if(oCnt>xCnt){
            if(check(board,'X')) return 0;
        }
        
        return 1;
    }
    private boolean check(String[] board, char c){
        // 가로
        for(int i=0; i<3; i++){
            if(board[i].charAt(0)==c && board[i].charAt(1)==c && board[i].charAt(2)==c) return true;
        }
        // 세로
        for(int i=0; i<3; i++){
            if(board[0].charAt(i)==c && board[1].charAt(i)==c && board[2].charAt(i)==c) return true;
        }
        // 대각
        if(board[0].charAt(0)==c&&board[1].charAt(1)==c&&board[2].charAt(2)==c) return true;
        if(board[0].charAt(2)==c&&board[1].charAt(1)==c&&board[2].charAt(0)==c) return true;
        return false;
    }
}