
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[][] arr;
    static boolean[] visited;
    static List<List<Integer>> list;
    static int res;
    public static void main(String[] args) throws IOException {
        input();
        calculate();
        if(res<=K) System.out.println(res);
        else System.out.println("Oh no");
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr= new int[N][2];
        visited = new boolean[N];
        res=0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1]= i;
        }
//        Arrays.sort(arr);
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]>o2[0]) return 1;
                else if(o1[0]==o2[0]) return 0;
                else  return -1;
            }
        });

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            list.get(x).add(y);
            list.get(y).add(x);

        }

    }
    private static void calculate(){
        for (int i = 0; i < N; i++) {
            if(!visited[arr[i][1]]){
                visited[arr[i][1]]=true;
                dfs(list.get(arr[i][1]));
                res+=arr[i][0];
            }
        }
    }


    private static void dfs(List<Integer> find){
        for (int i = 0; i < find.size(); i++) {
            int k = find.get(i);
            if(!visited[k]) {
                visited[k]=true;
                dfs(list.get(k));
            }
        }
    }
}
