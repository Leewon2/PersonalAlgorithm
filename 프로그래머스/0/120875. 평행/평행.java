class Solution {
    public int solution(int[][] dots) {
        double x = makeDot(dots[0][0],dots[0][1],dots[1][0],dots[1][1]);
        double y = makeDot(dots[2][0],dots[2][1],dots[3][0],dots[3][1]);
        if(calculate(x,y)) return 1;
        
        x = makeDot(dots[0][0],dots[0][1],dots[2][0],dots[2][1]);
        y = makeDot(dots[1][0],dots[1][1],dots[3][0],dots[3][1]);
        if(calculate(x,y)) return 1;
        
        x = makeDot(dots[0][0],dots[0][1],dots[3][0],dots[3][1]);
        y = makeDot(dots[2][0],dots[2][1],dots[1][0],dots[1][1]);
        if(calculate(x,y)) return 1;
        return 0;
    }
    private double makeDot(int x1, int y1, int x2, int y2){
        return (double) (y2-y1)/(x2-x1);
    }
    private boolean calculate(double x, double y){
        if(x==y) return true;
        return false;
    }
}