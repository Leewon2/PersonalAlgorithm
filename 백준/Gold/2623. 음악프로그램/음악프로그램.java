

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int[] point;
    static List<List<Integer>> list;
    static Queue<Integer> q;
    static List<Integer> res;
    public static void main(String[] args) throws IOException {
        input();
        order();
        if (res.size() != N) {
            System.out.println(0);
        }else{
            for (int i = 0; i < res.size(); i++) {
                System.out.println(res.get(i));
            }
        }
    }

    private static void order(){
        while (!q.isEmpty()) {
            int poll = q.poll();
            res.add(poll);
            for (int i = 0; i < list.get(poll).size(); i++) {
                int k = list.get(poll).get(i);
                point[k]--;
                if(point[k]==0){
                    q.offer(k);
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        point = new int[N + 1];
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        q = new ArrayDeque<>();
        res = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int before = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k-2; j++) {
                int x = Integer.parseInt(st.nextToken());
                list.get(before).add(x);
                before = x;
                point[x]++;
            }
            if(k!=1){
                int x = Integer.parseInt(st.nextToken());
                list.get(before).add(x);
                point[x]++;
            }
        }
        for (int i = 1; i <= N; i++) {
            if(point[i]==0){
                q.offer(i);
            }
        }
    }
}
