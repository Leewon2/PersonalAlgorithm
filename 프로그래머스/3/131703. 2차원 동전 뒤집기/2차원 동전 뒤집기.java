class Solution {
    int n, m;
    int[][] arr;
    int[][] tar;
    int answer;

    public int solution(int[][] beginning, int[][] target) {
        n = beginning.length;
        m = beginning[0].length;
        answer = Integer.MAX_VALUE;
        arr = new int[n][m];
        tar = target;

        for (int i = 0; i < n; i++) {
            for(int j=0; j<m; j++){
                arr[i][j] = beginning[i][j];
            }
        }
        dfs(0, 0);

        return (answer == Integer.MAX_VALUE) ? -1 : answer;
    }

    private void dfs(int row, int rowCnt) {
        if (rowCnt >= answer) return;

        if (row == n) {
            int colCnt = check();
            if (colCnt == Integer.MAX_VALUE) return;
            answer = Math.min(answer, rowCnt + colCnt);
            return;
        }

        dfs(row + 1, rowCnt);

        change(row);
        dfs(row + 1, rowCnt + 1);
        change(row);
    }

    private void change(int row) {
        for (int j = 0; j < m; j++) {
            if(arr[row][j]==0) arr[row][j]=1;
            else arr[row][j]=0;
        }
    }

    private int check() {
        int colCnt = 0;
        for (int col = 0; col < m; col++) {
            boolean flag = true;
            boolean c = true;

            for (int row = 0; row < n; row++) {
                int x = arr[row][col];
                int y = tar[row][col];

                if (x != y) flag = false;
                if ((x ^ 1) != y) c = false;
            }

            if (!flag && !c) {
                return Integer.MAX_VALUE;
            }
            if (c) colCnt++;
        }

        return colCnt;
    }
}