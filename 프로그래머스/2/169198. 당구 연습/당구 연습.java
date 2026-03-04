class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        for(int i=0; i<balls.length; i++){
            answer[i] = Math.min(checkWidth(m,n,startX,startY,balls[i][0],balls[i][1]),
                                checkHeight(m,n,startX,startY,balls[i][0],balls[i][1]));
        }
        return answer;
    }
    
    private int checkWidth(int m, int n, int sx, int sy, int ex, int ey){
        int min = Integer.MAX_VALUE;
        // 가로 왼쪽 벽
        // 세로 값이 같으면서, A보다 왼쪽에 있다면 왼쪽 벽 고려 X
        if(sy!=ey || sx<ex){
            int w = sx+ex;
            int h = Math.abs(sy-ey);
            min = Math.min(min, w*w+h*h);
        }
        
        // 가로 오른쪽 벽
        // 세로 값이 같으면서, A보다 오른쪽에 있다면 오른쪽 벽 고려X
        if(sy!=ey || sx>ex){
            int w = m-sx+m-ex;
            int h = Math.abs(sy-ey);
            min = Math.min(min, w*w+h*h);
        }
        
        return min;
    }
    
    private int checkHeight(int m, int n, int sx, int sy, int ex, int ey){
        int min = Integer.MAX_VALUE;
        // 세로 위 벽
        // 가로가 같으면서, A보다 목표 값의 y가 더 큰 경우 위 벽 고려 X
        if(sx!=ex || sy>ey){
            int w = Math.abs(sx-ex);
            int h = n-sy+n-ey;
            min = Math.min(min, w*w+h*h);
        }
        
        // 세로 아래 벽
        // 가로가 같으면서, A보다 목표 값의 y가 더 작은 경우 위 벽 고려 X
        if(sx!=ex || sy<ey){
            int w = Math.abs(sx-ex);
            int h = sy+ey;
            min = Math.min(min, w*w+h*h);
        }
        return min;
    }
}