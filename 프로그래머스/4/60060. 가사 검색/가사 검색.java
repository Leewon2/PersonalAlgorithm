import java.util.*;
class Solution {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Map<Integer, List<String>> map1 = new HashMap<>();
        Map<Integer, List<String>> map2 = new HashMap<>();
        for (String w : words) {
            int len = w.length();
            map1.computeIfAbsent(len, k -> new ArrayList<>()).add(w);
            String rev = new StringBuilder(w).reverse().toString();
            map2.computeIfAbsent(len, k -> new ArrayList<>()).add(rev);
        }

        for (List<String> list : map1.values()) {
            Collections.sort(list);
        }
        for (List<String> list : map2.values()) {
            Collections.sort(list);
        }
        for (int i = 0; i < queries.length; i++) {
            String s = queries[i];
            int len = s.length();
            if (!map1.containsKey(len)) {
                answer[i] = 0;
                continue;
            }

            if (s.charAt(0) == '?' && s.charAt(len - 1) == '?') {
                answer[i] = map1.get(len).size();
                continue;
            }

            if (s.charAt(0) != '?') {
                String left = s.replace('?', 'a');
                String right = s.replace('?', 'z');
                List<String> list = map1.get(len);
                answer[i] = count(list, left, right);
            }
            else {
                String rq = new StringBuilder(s).reverse().toString();
                String left = rq.replace('?', 'a');
                String right = rq.replace('?', 'z');
                List<String> list = map2.get(len);
                answer[i] = count(list, left, right);
            }
        }

        return answer;
    }

    private int count(List<String> list, String left, String right) {
        int l = binarySearch1(list, left);
        int r = binarySearch2(list, right);
        return r - l;
    }

    private int binarySearch1(List<String> list, String str) {
        int s = 0,
        e = list.size();
        while (s < e) {
            int mid = (s + e) / 2;
            if (list.get(mid).compareTo(str) >= 0) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    private int binarySearch2(List<String> list, String str) {
        int s = 0,
        e = list.size();
        while (s < e) {
            int mid = (s + e) / 2;
            if (list.get(mid).compareTo(str) > 0) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }
}
