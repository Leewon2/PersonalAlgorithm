

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {

        }
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(map.containsKey(x)){
                map.get(x).add(y);
            }else{
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(y);
                map.put(x, arrayList);
            }
            arr[i][0]=x;
            arr[i][1]=y;

        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });

        // 1. x가 하나 같은애 찾아야함.
        // 2. 그 x가 y2-y1 = b 인 애 찾아야함
        // 3. x+a인 애 찾아야함
        // 4. 그 x+a가 y1인 애 찾아야함
        // 5. x+a인 애 또 찾아야함
        // 6. 그 x+a가 y2-y1 = b인 애 찾아야함
        // 총 4개의 점이 필요하니까 0부터 N-3까지만 확인
        int cnt = 0;
        for (int i = 0; i < N - 3; i++) {
            // 1번
            int x1 = arr[i][0];
            int y1 = arr[i][1];
            // 점 3개를 찾자
            if(map.get(x1)==null || map.get(A+x1)==null) continue;
            //1 : x1이랑 같고, y1이랑 b차이나는 애 음수는 확인X 어차피 앞에서 확인함
            if ( !map.get(x1).contains(B+y1)) continue;
            //2 : x1이랑 a차이나는 애, y1이랑 같은애
            if ( !map.get(A+x1).contains(y1)) continue;
            //3 : x1이랑 a차이난애, y1이랑 b차이는 애
            if (!map.get(A+x1).contains(B+y1)) continue;
            cnt++;

        }
        System.out.println(cnt);
    }
}
