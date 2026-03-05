import java.util.*;

public class Solution {
    int[][] landClone;
    long p, q;

    public long solution(int[][] land, int P, int Q) {
        int n = land.length;
        landClone = new int[n][n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            landClone[i] = land[i].clone();
            for (int j = 0; j < n; j++) {
                min = Math.min(min, landClone[i][j]);
                max = Math.max(max, landClone[i][j]);
            }
        }
        p = P;
        q = Q;
        int l = min;
        int r = max;
        while (l < r) {
            int mid = (r+l)/2;
            long c1 = calculate(mid);
            long c2 = calculate(mid + 1);

            if (c1 <= c2) r = mid;
            else l = mid+1;
        }
        return calculate(l);
    }

    private long calculate(int num) {
        long add = 0;
        long remove = 0;

        for (int[] i : landClone) {
            for (int j : i) {
                if (num > j) add += num-j;
                else remove += j-num;
            }
        }

        return p*add+q*remove;
    }
}