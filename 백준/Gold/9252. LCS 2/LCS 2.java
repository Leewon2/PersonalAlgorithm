

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();
        int rowLen = arr1.length;
        int colLen = arr2.length;
        int[][] dp = new int[rowLen + 1][colLen + 1];
        for (int r = 1; r <= rowLen; r++) {
            for (int c = 1; c <= colLen; c++) {
                if (arr1[r - 1] == arr2[c - 1]) {
                    dp[r][c] = dp[r - 1][c - 1] + 1;
                }else{
                    dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
                }
            }
        }
        System.out.println(dp[rowLen][colLen]);

        Stack<Character> stack = new Stack<>();
        while (true) {
            if(rowLen==0 || colLen==0) break;
            if (dp[rowLen][colLen] == dp[rowLen - 1][colLen]) {
                rowLen--;
            } else if (dp[rowLen][colLen] == dp[rowLen][colLen - 1]) {
                colLen--;
            }else{
                stack.add(arr1[rowLen-1]);
                rowLen--;
                colLen--;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
