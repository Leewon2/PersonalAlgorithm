import java.util.*;
class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String s = toFullBinary(numbers[i]);
            answer[i] = isValidTree(s) ? 1 : 0;
        }

        return answer;
    }

    private String toFullBinary(long num) {
        String s = Long.toBinaryString(num);
        int len = s.length();

        int[] arr = {1, 3, 7, 15, 31, 63};
        int target = 63;
        for (int v : arr) {
            if (v >= len) {
                target = v;
                break;
            }
        }

        int need = target - len;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < need; i++) sb.append('0');
        sb.append(s);

        return sb.toString();
    }

    private boolean isValidTree(String s) {
        int mid = s.length() / 2;
        char root = s.charAt(mid);
        if (s.length() == 1) return true;
        String left = s.substring(0, mid);
        String right = s.substring(mid + 1);
        if (root == '0') {
            if (left.contains("1") || right.contains("1")) return false;
        }
        return isValidTree(left) && isValidTree(right);
    }
}
