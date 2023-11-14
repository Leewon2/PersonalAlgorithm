

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] visited = new boolean[n];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        int res=0;
        visited[0]=true;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            list.get(x).add(y);
            list.get(y).add(x);
            if(x==0 && !visited[y]){
                visited[y]=true;
                q.offer(y);
                res++;
            }else if(y==0 && !visited[x]){
                visited[x]=true;
                q.offer(x);
                res++;
            }
        }
        while (!q.isEmpty()) {
            int poll = q.poll();
            for (int i = 0; i < list.get(poll).size(); i++) {
                int k = list.get(poll).get(i);
                if(!visited[k]){
                    res++;
                    visited[k]=true;
                }
            }
        }
        System.out.println(res);


    }
}
