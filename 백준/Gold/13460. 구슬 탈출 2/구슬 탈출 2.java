import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] arr;
    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, 1, 0, -1};
    static Queue<RB> q;
    static boolean goalRed;
    static boolean goalBlue;
    static boolean inner;
    static boolean[][][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        Node redLocation = new Node(0, 0);
        Node blueLocation = new Node(0, 0);
        for (int r = 0; r < N; r++) {
            String str = br.readLine();
            for (int c = 0; c < M; c++) {
                arr[r][c] = str.charAt(c);
                if (arr[r][c] == 'R') {
                    redLocation = new Node(r, c);
                } else if (arr[r][c] == 'B') {
                    blueLocation = new Node(r, c);
                }
            }
        }
        visited = new boolean[N][M][N][M];

        inner = false;
        goalRed = false;
        goalBlue = false;
        q = new LinkedList<>();
        q.offer(new RB(redLocation, blueLocation, 0));
        System.out.println(BFS());
    }

    private static int BFS() {
        int res = 0;
        while (!q.isEmpty()) {
            RB poll = q.poll();
            Node red = poll.redLocation;
            Node blue = poll.blueLocation;
            if(visited[red.r][red.c][blue.r][blue.c]) continue;
            visited[red.r][red.c][blue.r][blue.c] = true;
            int cnt = poll.cnt;
            if (cnt >= 10) continue;
            for (int i = 0; i < 4; i++) {
                RB rb = canGo(red, blue, cnt, i);
                if (inner) {
                    if (goalRed && !goalBlue) {
                        return cnt+1;
                    }
                    goalRed = false;
                    goalBlue = false;
                    inner = false;
                } else {
                    q.offer(rb);
                }
            }
        }

        return -1;
    }

    private static RB canGo(Node red, Node blue, int cnt, int dir) {
        Node newRedLocation = null, newBlueLocation = null;
        char[][] subArr = new char[N][M];
        // 같은 행에 있는 경우
        if (red.r == blue.r) {
            // 왼쪽에 있는 것이 무엇일까?
            if (red.c < blue.c) {
                // red가 왼쪽인 경우, dir이 1인 경우 오른쪽으로 이동하므로, blue 먼저 시행
                // dir이 3인 경우 왼쪽으로 이동하므로 red먼저 시행
                if (dir == 1) {
                    newBlueLocation = Move(blue, dir, subArr, 0);
                    newRedLocation = Move(red, dir, subArr, 1);
                } else {
                    newRedLocation = Move(red, dir, subArr, 1);
                    newBlueLocation = Move(blue, dir, subArr, 0);
                }

            } else {
                // red가 오른쪽인 경우 dir이 1인 경우 오른쪽으로 이동하므로, red 먼저 시행
                if (dir == 1) {
                    newRedLocation = Move(red, dir, subArr, 1);
                    newBlueLocation = Move(blue, dir, subArr, 0);
                } else {
                    newBlueLocation = Move(blue, dir, subArr, 0);
                    newRedLocation = Move(red, dir, subArr, 1);
                }
            }
        }

        // 같은 열에 있는 경우
        else if (red.c == blue.c) {
            if (red.r < blue.r) {
                // red가 위쪽인 경우, dir이 0인 경우 아래로 이동하므로, blue 먼저 시행
                // dir이 2인 경우 위로 이동하므로 red먼저 시행
                if (dir == 0) {
                    newBlueLocation = Move(blue, dir, subArr, 0);
                    newRedLocation = Move(red, dir, subArr, 1);
                } else {
                    newRedLocation = Move(red, dir, subArr, 1);
                    newBlueLocation = Move(blue, dir, subArr, 0);
                }

            } else {
                // red가 아래쪽 경우, dir이 0인 경우 위로 이동하므로, red 먼저 시행
                if (dir == 0) {
                    newRedLocation = Move(red, dir, subArr, 1);
                    newBlueLocation = Move(blue, dir, subArr, 0);
                } else {
                    newBlueLocation = Move(blue, dir, subArr, 0);
                    newRedLocation = Move(red, dir, subArr, 1);
                }
            }
        } else {
            newRedLocation = Move(red, dir, subArr, 1);
            newBlueLocation = Move(blue, dir, subArr, 0);
        }




        return new RB(newRedLocation, newBlueLocation, cnt + 1);

    }

    private static Node Move(Node node, int dir, char[][] subArr, int color) {
        int nr = node.r;
        int nc = node.c;
        while (true) {
            nr += dr[dir];
            nc += dc[dir];
            if (arr[nr][nc] == 'O') {
                inner = true;
                if (color == 1) {
                    goalRed = true;
                } else {
                    goalBlue = true;
                }
            }

            if (arr[nr][nc] == '#' || subArr[nr][nc] == 'R' || subArr[nr][nc] == 'B') {
                nr -= dr[dir];
                nc -= dc[dir];
                subArr[nr][nc] = 'R';
                return new Node(nr, nc);
            }
        }
    }

    private static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static class RB {
        Node redLocation;
        Node blueLocation;
        int cnt;

        public RB(Node redLocation, Node blueLocation, int cnt) {
            this.redLocation = redLocation;
            this.blueLocation = blueLocation;
            this.cnt = cnt;
        }
    }
}
