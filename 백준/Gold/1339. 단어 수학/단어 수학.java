

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        Integer[] alphabet = new Integer[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = new Integer(0); // 초기화
        }


        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                int find = arr[i].charAt(j) - 'A';
                alphabet[find] +=(int) Math.pow(10, arr[i].length() - j-1);
            }
        }
        Arrays.sort(alphabet, Collections.reverseOrder());
        int cnt=9;
        int res=0;
        for (int i = 0; i < alphabet.length; i++) {
            res += alphabet[i]*cnt--;
        }

        System.out.println(res);


    }
}
