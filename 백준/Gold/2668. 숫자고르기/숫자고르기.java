

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static List<Integer> list;
    static boolean[] visited;
    static List<Integer> res;
    static int last;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        visited = new boolean[N];
        arr = new int[N];
        res = new ArrayList<>();
        last = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine()) - 1;
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            last = i;
            dfs(i);
            visited[i]=false;
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (int idx : list) {
            System.out.println(idx+1);  
        }
    }

    private static void dfs(int find) {
        if (!visited[arr[find]]) {
            visited[arr[find]]=true;
            dfs(arr[find]);
            visited[arr[find]]=false;
        }
        if (arr[find] == last) {
            list.add(last);
        }
    }
}