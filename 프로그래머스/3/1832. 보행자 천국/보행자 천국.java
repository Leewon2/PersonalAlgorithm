class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][] newCityMap = new int[m+2][n+2];
        for(int r=1; r<=m; r++){
            for(int c=1; c<=n; c++){
                newCityMap[r][c] = cityMap[r-1][c-1];
            }
        }
        // 0은 위에서 아래로 내려옴, 1은 왼쪽에서 오른쪽으로
        int[][][] arr = new int[m+2][n+2][2];
        // 출발은 1,1 도착은 m,n
        arr[1][1][0]=1;
        arr[1][1][1]=1;
        for(int r=1; r<=m; r++){
            for(int c=1; c<=n; c++){
                if(newCityMap[r][c]==1) continue;
                if(r==1 && c==1) continue;
                
                if(newCityMap[r][c]==0){
                      arr[r][c][0] += (arr[r-1][c][0] + arr[r][c-1][1]) % 20170805;
                      arr[r][c][1] += (arr[r-1][c][0] + arr[r][c-1][1]) % 20170805;
                  }else {
                      arr[r][c][0] = arr[r-1][c][0];
                      arr[r][c][1] = arr[r][c-1][1];
                  }
            }
        }
        return arr[m][n][0];
    }
}