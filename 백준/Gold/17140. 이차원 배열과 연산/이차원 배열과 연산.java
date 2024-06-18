import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int r, c, k;
    static int[][] arr;
    static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());
        arr = new int[3][3];
        int time = 0;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean check = false;
        for (int i = 0; i <= 100; i++) {
            if (arr.length > r && arr[0].length > c) {
                if (arr[r][c] == k) {
                    System.out.println(time);
                    check = true;
                    break;
                }
            }
            int rr = arr.length;
            int cc = arr[0].length;
            if (rr >= cc) {
                int size = rowCalculate(rr, cc);
                if (size > 100) size = 100;
                int[][] subArr = new int[rr][size];
                makeRowArr(subArr,rr,cc);
            } else {
                int size = colCalculate(rr, cc);
                if (size > 100) size = 100;
                int[][] subArr = new int[size][cc];
                makeColArr(subArr,rr,cc);
            }
            time++;
        }
        if(!check) System.out.println(-1);
    }

    private static int rowCalculate(int r, int c) {
        int decideArrSize = 0;
        for (int i = 0; i < r; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 0) continue;
                set.add(arr[i][j]);
            }
            // 한개의 행이 끝나면, 배열의 크기를 정한다.
            decideArrSize = Math.max(decideArrSize, set.size() * 2);
        }
        return decideArrSize;
    }
    private static int colCalculate(int r, int c) {
        int decideArrSize = 0;
        for (int i = 0; i < c; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < r; j++) {
                if (arr[j][i] == 0) continue;
                set.add(arr[j][i]);
            }
            decideArrSize = Math.max(decideArrSize, set.size() * 2);
        }
        return decideArrSize;
    }


    private static void makeRowArr(int[][] subArr, int r, int c) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.cnt != o2.cnt) {
                return o1.cnt - o2.cnt;
            }
            return o1.num - o2.num;
        });
        for (int i = 0; i < r; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 0) continue;
                if (map.get(arr[i][j]) == null) {
                    map.put(arr[i][j], 1);
                } else {
                    map.put(arr[i][j], map.get(arr[i][j]) + 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                pq.offer(new Node(entry.getKey(), entry.getValue()));
            }
            int idx = 0;
            while (!pq.isEmpty()) {
                if (idx >= 100) break;
                Node poll = pq.poll();
                subArr[i][idx++] = poll.num;
                subArr[i][idx++] = poll.cnt;
            }
            pq.clear();
        }
        arr = new int[subArr.length][subArr[0].length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Arrays.copyOf(subArr[i], subArr[0].length);
        }

    }

    private static void makeColArr(int[][] subArr, int r, int c) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.cnt != o2.cnt) {
                return o1.cnt - o2.cnt;
            }
            return o1.num - o2.num;
        });
        for (int i = 0; i < c; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < r; j++) {
                if (arr[j][i] == 0) continue;
                if (map.get(arr[j][i]) == null) {
                    map.put(arr[j][i], 1);
                } else {
                    map.put(arr[j][i], map.get(arr[j][i]) + 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                pq.offer(new Node(entry.getKey(), entry.getValue()));
            }
            int idx = 0;
            while (!pq.isEmpty()) {
                if (idx >= 100) break;
                Node poll = pq.poll();
                subArr[idx++][i] = poll.num;
                subArr[idx++][i] = poll.cnt;
            }
            pq.clear();

        }
        arr = new int[subArr.length][subArr[0].length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Arrays.copyOf(subArr[i], subArr[0].length);
        }
    }

    private static class Node {
        int num;
        int cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
