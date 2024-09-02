class Solution {
    public int solution(int[] a) {
        int len = a.length;
        int[] cnt = new int[len];
        for (int i = 0; i < len; i++) {
            cnt[a[i]]++;
        }

        int max = 0;
        for (int i = 0; i < len; i++) {
            if (cnt[i] <= max) continue;
            int localLen = 0;
            for (int j = 0; j < len - 1; j++) {
                if (a[j] != i && a[j + 1] != i) continue;
                if (a[j] == a[j + 1]) continue;
                localLen++;
                j++;
            }
            max = Math.max(max, localLen);
        }
        return max * 2;
    }
}