

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] p;
    static int[] f;
    static int[] s;
    static int[] v;
    static int[] price;
    static int mp;
    static int mf;
    static int ms;
    static int mv;

    static boolean[] check;
    static int min;
    static String str;

    static ArrayList<Integer> rlist;

    public static void main(String[] args) throws IOException {
        input();
        ArrayList<Integer> list = new ArrayList<>();
        backtracking(0, 0, 0, 0, 0, 0, list);
        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else {
            System.out.println(min);
            Collections.sort(rlist);
            for (int i = 0; i < rlist.size(); i++) {
                System.out.print(rlist.get(i) + " ");
            }


        }
    }

    private static void backtracking(int idx, int sump, int sumf, int sums, int sumv, int pr, ArrayList<Integer> list) {

        if (sump >= mp && sumf >= mf && sums >= ms && sumv >= mv) {
            if (pr < min || (pr == min && isBetterCombination(list, rlist))) {
                min = pr;
                rlist = new ArrayList<>(list);
            }
            return;
        }

        if (idx == N || pr >= min) {
            return;
        }


        list.add(idx+1);
        backtracking(idx + 1, sump + p[idx], sumf + f[idx], sums + s[idx], sumv + v[idx], pr + price[idx], list);
        list.remove(list.size() - 1);
        backtracking(idx + 1, sump, sumf, sums, sumv, pr, list);
    }

    private static boolean isBetterCombination(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) < list2.get(i)) {
                return true;
            } else if (list1.get(i) > list2.get(i)) {
                return false;
            }
        }
        return false;
    }

    private static String com(String k) {
        for (int i = 0; i < k.length(); i++) {
            int x = Character.getNumericValue(str.charAt(i));
            int y = Character.getNumericValue(k.charAt(i));
            if (x > y) return k;
            else if (x < y) return str;
        }
        return str;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        p = new int[N];
        f = new int[N];
        s = new int[N];
        v = new int[N];
        price = new int[N];
        check = new boolean[N];
        rlist = new ArrayList<>();
        str = "";
        st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            p[i] = Integer.parseInt(st.nextToken());
            f[i] = Integer.parseInt(st.nextToken());
            s[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());

        }
    }
}
