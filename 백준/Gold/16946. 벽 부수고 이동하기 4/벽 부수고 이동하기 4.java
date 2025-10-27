import javax.xml.transform.Result;
import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, Integer> map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String string = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = string.charAt(j) - '0';
            }
        }
        int[][] subArr = new int[N][M];

        map = new HashMap<>();
        int idx=1;
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(arr[r][c]!=1 && !visited[r][c]){
                    visited[r][c] = true;
                    subArr[r][c] = idx;
                    q.offer(new int[]{r,c});
                    int cnt=1;
                    while(!q.isEmpty()){
                        int[] poll = q.poll();
                        int pr = poll[0];
                        int pc = poll[1];

                        for(int d=0; d<4; d++){
                            int nr = pr + dr[d];
                            int nc = pc + dc[d];
                            if(nr>=0 && nr<N && nc>=0 && nc<M){
                                if(arr[nr][nc]!=1 && !visited[nr][nc]){
                                    visited[nr][nc] = true;
                                    subArr[nr][nc] = idx;
                                    q.offer(new int[]{nr,nc});
                                    cnt++;
                                }
                            }
                        }
                    }
                    map.put(idx, cnt);
                    idx++;
                }
            }
        }
        int[][] result = new int[N][M];
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(arr[r][c]==1){
                    Set<Integer> set = new HashSet<>();
                    for(int d=0; d<4; d++){
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if(nr>=0 && nr<N && nc>=0 && nc<M){
                            if(arr[nr][nc]!=1){
                                set.add(subArr[nr][nc]);
                            }
                        }
                    }
                    int sum=1;
                    for(int key : set){
                        sum += map.get(key);
                    }
                    result[r][c] = sum % 10;
                }
            }
        }
        for(int[] i : result){
            for(int j : i){
                System.out.print(j);
            }
            System.out.println();
        }
    }




}
