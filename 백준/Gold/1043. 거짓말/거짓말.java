import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 진실을 아는 사람 배열 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int trueCnt = Integer.parseInt(st.nextToken());
        int[] truePeople = new int[trueCnt];
        boolean[] tp = new boolean[N + 1];
        for (int i = 0; i < trueCnt; i++) {
            int k = Integer.parseInt(st.nextToken());
            truePeople[i] = k;
            tp[k] = true;
        }

        // 파티 배열 저장
        List<List<Integer>> partyPeople = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            partyPeople.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            for (int tc = 0; tc < t; tc++) {
                partyPeople.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        // List<List<>>를 통해, 파티 배열 양방향 저장
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < partyPeople.size(); i++) {
            for (int j = 0; j < partyPeople.get(i).size(); j++) {
                int p1 = partyPeople.get(i).get(j);
                for (int k = 0; k < partyPeople.get(i).size(); k++) {
                    if(j==k) continue;
                    int p2 = partyPeople.get(i).get(k);
                    list.get(p1).add(p2);
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < truePeople.length; i++) {
            q.offer(truePeople[i]);
        }

        // list.get(진실을 아는 사람)을 해서 연관된 사람을 모두 true로 저장
        while (!q.isEmpty()) {
            int poll = q.poll();
            for (int i = 0; i < list.get(poll).size(); i++) {
                int k = list.get(poll).get(i);
                if(!tp[k]){
                    tp[k]= true;
                    q.offer(k);
                }
            }
        }

        int res = 0;
        // 파티 배열 돌면서, 모두 false면 cnt + 1
        for (int i = 0; i < partyPeople.size(); i++) {
            boolean check = true;
            for (int j = 0; j < partyPeople.get(i).size(); j++) {
                if(tp[partyPeople.get(i).get(j)]){
                    check =false;
                    break;
                }
            }
            if(check) res++;
        }
        System.out.println(res);
    }
}
