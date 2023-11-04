

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<List<Integer>> arr;
    static boolean[] visited;
    static int find;
    static int res;
    public static void main(String[] args)  throws IOException {
        input();
    }

    private static void cut(int idx){
        visited[idx] = true;
        for (int i = 0; i < arr.get(idx).size(); i++) {
            visited[arr.get(idx).get(i)]=true;
            cut(arr.get(idx).get(i));
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new ArrayList<List<Integer>>();
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<Integer>());
        }
        res=0;
        visited = new boolean[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int k = Integer.parseInt(st.nextToken())+1;
            arr.get(k).add(i);
        }
        find = Integer.parseInt(br.readLine())+1;
        cut(find);
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                int k = arr.get(i).get(j);
                if(visited[k]) arr.get(i).remove(new Integer(k));
            }
        }
        for(int i=1; i<=N; i++){
            if(!visited[i] && arr.get(i).isEmpty()) res++;
        }
        System.out.println(res);
    }
}
