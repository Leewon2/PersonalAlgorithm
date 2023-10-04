
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static int[][] map;
    static int[][] copyMap;

    static int[] bullet;
    static int[] shootBulletArr;
    static boolean[][] check;

    static final int[] dr = {0,1,0,-1};
    static final int[] dc = {1,0,-1,0};

    static int res;


    public static void main(String[] args) throws IOException {
        input();
        backtracking(0);
        System.out.println(res);

    }

    private static void copy(){
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                copyMap[r][c] = map[r][c];
            }
        }

    }

    private static int shoot(int idx , int whereBullet){
        // N번째 열 까지 확인
        int k =0;
        for (int i = 0; i < N; i++) {
            // 10이면 그냥 10 return
            if(copyMap[idx][i]>=10){

                k=copyMap[idx][i];
                copyMap[idx][i]=0;
                return k;
            }
            // 점수가 있는 경우
            else if (copyMap[idx][i] > 0) {
                // 불릿보다 점수가 작은 경우
                if(bullet[whereBullet]>=copyMap[idx][i]){
                    for (int j = 0; j < 4; j++) {
                        int nr = idx+dr[j];
                        int nc = i+dc[j];
                        // 범위를 벗어나거나 0이 아니면 continue
                        if(nr<0 || nc<0 || nr>=N || nc>=N || copyMap[nr][nc]!=0) continue;
                        copyMap[nr][nc]=map[idx][i]/4;
                    }
                    if(check[idx][i]){
                        k = map[idx][i];
                        check[idx][i] = false;
                    }else{
                        k = copyMap[idx][i];
                    }
                    copyMap[idx][i]=0;
                    return k;
                }
                // 불릿보다 점수가 큰 경우
                else{
                    // 점수만 마이너스
                    copyMap[idx][i] -= bullet[whereBullet];
                    check[idx][i] = true;
                    return 0;
                }
            }
        }

        return 0;

    }

    // 중복순열로 확인
    private static void backtracking(int idx){
        // 기저조건
        if(idx==K){
            // 배열 복사
            copy();
            check = new boolean[N][N];
            // idx에 슛팅
            int sum=0;
            for (int i = 0; i < K; i++) {
                sum +=shoot(shootBulletArr[i],i);
            }
            res = Math.max(res, sum);
            return;
        }


        // 재귀조건
        for (int i = 0; i < N; i++) {
            shootBulletArr[idx]=i;
            backtracking(idx+1);
        }

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N][N];
        copyMap = new int[N][N];
        bullet = new int[K];
        shootBulletArr = new int[K];
        check = new boolean[N][N];
        res=0;

        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            bullet[i] = Integer.parseInt(st.nextToken());
        }
    }
}
