

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T = br.readLine();
        String P = br.readLine();
        List<Integer> res = KMP(T, P);
        System.out.println(res.size());
        StringBuilder sb = new StringBuilder();
        for (int l : res) {
            sb.append(l).append("\n");
        }
        System.out.println(sb);
    }

    private static List<Integer> KMP(String T, String P) {
        List<Integer> list = new ArrayList<>();
        int j=0;
        int[] pi = new int[P.length()];
        for (int i = 1; i < P.length(); i++) {
            while (j > 0 && P.charAt(i) != P.charAt(j)) {
                j = pi[j - 1];
            }
            if (P.charAt(i) == P.charAt(j)) {
                pi[i]=++j;
            }
        }


        StringBuilder sb = new StringBuilder();

        j = 0;
        for (int i = 0; i < T.length(); i++) {
            while (j > 0 && T.charAt(i) != P.charAt(j)) {
                j = pi[j - 1];
            }
            if (T.charAt(i) == P.charAt(j)) {
                if (j == P.length()-1) {
                    list.add(i - j + 1);
                    j = pi[j];

                }else{
                    j++;
                }
            }
        }

        return list;
    }
}
