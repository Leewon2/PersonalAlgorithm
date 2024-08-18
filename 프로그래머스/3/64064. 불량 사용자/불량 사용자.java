import java.util.*;
class Solution {
    static int answer;
    static boolean[] visited;
    static String[] compare;
    static int userIdx, banIdx;
    static Set<String> set;

    public static int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        userIdx = user_id.length;
        banIdx = banned_id.length;
        visited = new boolean[userIdx];
        compare = new String[banIdx];
        set = new HashSet<>();
        comb(0, user_id, banned_id);
        return set.size();
    }

    // 조합
    private static void comb(int idx, String[] user_id, String[] banned_id) {
        if (idx == banIdx) {
            for (int i = 0; i < banIdx; i++) {
                if (compare[i].length() != banned_id[i].length()) return;
                for (int j = 0; j < compare[i].length(); j++) {
                    if (banned_id[i].charAt(j) == '*') continue;
                    if (banned_id[i].charAt(j) != compare[i].charAt(j)) return;
                }
            }
            String[] c = compare.clone();
            Arrays.sort(c);
            StringBuilder sb = new StringBuilder();
            for (String s : c) {
                sb.append(s);
            }
            set.add(sb.toString());

            return;
        }
        for (int i = 0; i < userIdx; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            compare[idx] = user_id[i];
            comb(idx + 1, user_id, banned_id);
            visited[i] = false;
        }
    }
}