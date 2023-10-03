

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    // 이동 순서
    static final int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static final int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};

    // 대각선 확인
    static final int[] crossR = {-1, -1, 1, 1};
    static final int[] crossC = {-1, 1, 1, -1};

    // 구름이었는지 판별하는 boolean
    static boolean[][] cloud;

    // 구름의 이동 및 생성되는 구름 판별하는 boolean
    static boolean[][] copyCloud;

    // 맵
    static int[][] map;
    static int[][] copyMap;

    static int N;
    static int M;

    // 이동을 저장할 배열
    static int[][] move;

    public static void main(String[] args) throws IOException {
        input();
        firstMakeCloud();

        for (int i = 0; i < M; i++) {
            secondMoveCloud(i);
            thirdIncreaseWater();
            fourthCheckCrossWater();
            finalMakeCloudAndDecreaseWater();
        }

        System.out.println(calculate());
        // 1. (N,1), (N,2), (N-1, 1), (N-1, 2)에 비구름이 생성
        // 2. 모든 구름이 di 방향으로 si칸 이동
        // 3. 바구니에 저장된 물의 양 1 증가
        // 4. 구름이 모두 사라짐
        // 5. 현재 선택된 칸에서 대각선에 물이 1 이상인 수 만큼 선택된 칸 물 증가
        // 6. 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다.
        // 이 때, 3에서 구름이 사라진 칸은 제외된다.
        // M번의 이동이 모드 끝난 후 바구니에 들어있는 물의 양의 합을 구하자.


    }

    // 계산
    private static int calculate(){
        int sum=0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                sum+=map[r][c];
            }
        }
        return sum;
    }

    // 5. 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다.
    // 이 때, 원래 구름이었던 칸(copyCloud)은 제외된다.
    private static void finalMakeCloudAndDecreaseWater(){
        // 초기화
        cloud = new boolean[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (copyCloud[r][c]) continue;
                if(map[r][c]>=2){
                    cloud[r][c] = true;
                    map[r][c]-=2;
                }
            }
        }
        // copyCloud 초기화
        copyCloud = new boolean[N][N];
    }

    // 4. 현재 선택된 칸에서 대각선 물이 1 이상인 수 만큼 선택된 칸 물 증가
    private static void fourthCheckCrossWater() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (copyCloud[r][c]) {
                    for (int i = 0; i < 4; i++) {
                        int nr = r + crossR[i];
                        int nc = c + crossC[i];
                        if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                        if (map[nr][nc] >= 1) copyMap[r][c]++;
                    }
                }
            }
        }
        // 다 끝난 후 합치기
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] += copyMap[r][c];
            }
        }
        // 초기화
        copyMap = new int[N][N];

    }

    // 3. 바구니에 저장된 물의 양 1 증가
    private static void thirdIncreaseWater() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (copyCloud[r][c]) {
                    map[r][c]++;
                }
            }
        }
    }

    // 2. 구름의 이동
    private static void secondMoveCloud(int idx) {
        int dir = move[idx][0];
        int mv = move[idx][1];
        int dirMoveX = dr[dir - 1] * mv;
        int dirMoveY = dc[dir - 1] * mv;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // true인 경우 copyCloud로 이동
                if (cloud[r][c]) {
                    copyCloud[Math.abs(N*50000+r + dirMoveX)%N][Math.abs(N*50000+c+dirMoveY)%N] = true;
                }
            }
        }
    }


    // 1. 가장 처음 비구름 생성
    private static void firstMakeCloud() {
        cloud[N - 1][0] = true;
        cloud[N - 1][1] = true;
        cloud[N - 2][0] = true;
        cloud[N - 2][1] = true;
    }

    // input
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        copyMap = new int[N][N];
        move = new int[M][2];
        cloud = new boolean[N][N];
        copyCloud = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            move[i][0] = Integer.parseInt(st.nextToken());
            move[i][1] = Integer.parseInt(st.nextToken());
        }
    }

}
