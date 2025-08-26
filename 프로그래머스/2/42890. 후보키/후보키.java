import java.util.*;

class Solution {
    boolean[] use;
    List<List<Integer>> keys;
    int answer, R, C;

    public int solution(String[][] relation) {
        R = relation.length;
        C = relation[0].length;

        use = new boolean[C];
        keys = new ArrayList<>();
        answer = 0;

        for (int size = 1; size <= C; size++) {
            int[] idxArr = new int[size];
            dfs(size, 0, 0, idxArr, relation);
        }
        return answer;
    }

    private void dfs(int idx, int start, int now, int[] idxArr, String[][] relation) {
        if (now == idx) {
            if (isMinimal(idxArr) && isUnique(idxArr, relation)) {
                List<Integer> key = new ArrayList<>();
                for (int v : idxArr) key.add(v);
                keys.add(key);
                answer++;
            }
            return;
        }

        for (int col = start; col < C; col++) {
            if (!use[col]) {
                use[col] = true;
                idxArr[now] = col;
                dfs(idx, col + 1, now + 1, idxArr, relation);
                use[col] = false;
            }
        }
    }

    private boolean isMinimal(int[] idxArr) {
        Set<Integer> cur = new HashSet<>();
        for (int v : idxArr) cur.add(v);

        for (List<Integer> key : keys) {
            if (cur.containsAll(key)) return false;
        }
        return true;
    }

    private boolean isUnique(int[] idxArr, String[][] relation) {
        Set<String> seen = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int r = 0; r < R; r++) {
            sb.setLength(0);
            for (int c : idxArr) {
                sb.append(relation[r][c]).append('|');
            }
            if (!seen.add(sb.toString())) return false;
        }
        return true;
    }
}
