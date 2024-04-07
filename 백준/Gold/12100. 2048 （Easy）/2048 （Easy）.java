import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] copyArr;
    static int max;
    static int[] number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        copyArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                copyArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        number = new int[5];
        max = 0;
        perm(0);
        System.out.println(max);
    }

    // 5가지의 중복순열 경우의 수를 만들고, 5가 됐을 때, 최댓값을 찾아본다.
    private static void perm(int idx) {
        if (idx == 5) {
            // 계산하는 함수
            // 0 : left 1 : right, 2 : down, 3 : up
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                arr[i] = copyArr[i].clone();
            }
//                System.out.println(number[i]);
            for (int i = 0; i < 5; i++) {
                switch (number[i]) {
                    case 0:
                        moveLeft();
//                        for(int[] list : arr){
//                            System.out.println(Arrays.toString(list));
//                        }
                        break;
                    case 1:
                        moveRight();
                        break;
                    case 2:
                        moveDown();
                        break;
                    case 3:
                        moveUp();
                        break;
                }
            }

            calculateMaxValue();
            return;
        }
        for (int i = 0; i < 4; i++) {
            number[idx] = i;
            perm(idx + 1);
        }

    }

    private static void calculateMaxValue() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                max = Math.max(max, arr[r][c]);
            }
        }
    }

    // 왼쪽으로 이동
    private static void moveLeft() {
        for (int i = 0; i < N; i++) {
            int idx = 0;
            // 가장 처음 0이 아닌 값을 찾는다.
            int before = 0;
            int start = 50;
            for (int k = 0; k < N; k++) {
                if (arr[i][k] != 0) {
                    start = k + 1;
                    before = arr[i][k];
                    arr[i][k]=0;
                    break;
                }
            }
            for (int j = start; j < N; j++) {
                if (arr[i][j] == 0) continue;
                // 같은 경우 합쳐져야한다.
                if (arr[i][j] == before) {
                    arr[i][idx++] = before * 2;
                    before = 0;
                    arr[i][j] = 0;
                }
                // 다른 경우 왼쪽으로 이동시키고 before 값이 갱신되어야 한다.
                else {
                    // before 값이 0이라면, before값만 저장한다.
                    if (before == 0) {
                        before = arr[i][j];
                        arr[i][j] = 0;
                    } else {
                        arr[i][idx++] = before;
                        before = arr[i][j];
                        arr[i][j] = 0;
                    }
                }
            }
            if (before != 0) {
                arr[i][idx] = before;
            }
        }
    }

    // 오른쪽으로 이동
    private static void moveRight() {
        for (int i = 0; i < N; i++) {
            int idx = N - 1;
            int before = 0;
            int start = -1;
            for (int k = N - 1; k >= 0; k--) {
                if (arr[i][k] != 0) {
                    start = k - 1;
                    before = arr[i][k];
                    arr[i][k]=0;
                    break;
                }
            }
            for (int j = start; j >= 0; j--) {
                if (arr[i][j] == 0) continue;
                // 같은 경우 합쳐져야한다. 두번 합쳐지면 안되므로, before 값은 다시 갱신해준다.
                if (arr[i][j] == before) {
                    arr[i][idx--] = before * 2;
                    before = 0;
                    arr[i][j] = 0;
                }
                // 다른 경우 왼쪽으로 이동시키고 before 값이 갱신되어야 한다.
                else {
                    if (before == 0) {
                        before = arr[i][j];
                        arr[i][j] = 0;
                    } else {
                        arr[i][idx--] = before;
                        before = arr[i][j];
                        arr[i][j] = 0;
                    }
                }
            }
            if (before != 0) {
                arr[i][idx] = before;
            }
        }
    }

    // 위쪽으로 이동
    private static void moveUp() {
        for (int i = 0; i < N; i++) {
            int idx = 0;
            // 가장 처음 0이 아닌 값을 찾는다.
            int before = 0;
            int start = 50;
            for (int k = 0; k < N; k++) {
                if (arr[k][i] != 0) {
                    start = k + 1;
                    before = arr[k][i];
                    arr[k][i]=0;
                    break;
                }
            }
            for (int j = start; j < N; j++) {
                if (arr[j][i] == 0) continue;
                // 같은 경우 합쳐져야한다.
                if (arr[j][i] == before) {
                    arr[idx++][i] = before * 2;
                    before = 0;
                    arr[j][i] = 0;
                }
                // 다른 경우 왼쪽으로 이동시키고 before 값이 갱신되어야 한다.
                else {
                    // before 값이 0이라면, before값만 저장한다.
                    if (before == 0) {
                        before = arr[j][i];
                        arr[j][i] = 0;
                    } else {
                        arr[idx++][i] = before;
                        before = arr[j][i];
                        arr[j][i] = 0;
                    }
                }
            }
            if (before != 0) {
                arr[idx][i] = before;
            }
        }
    }

    // 아랫쪽으로 이동
    private static void moveDown() {
        for (int i = 0; i < N; i++) {
            int idx = N - 1;
            int before = 0;
            int start = -1;
            for (int k = N - 1; k >= 0; k--) {
                if (arr[k][i] != 0) {
                    start = k - 1;
                    before = arr[k][i];
                    arr[k][i]=0;
                    break;
                }
            }
            for (int j = start; j >= 0; j--) {
                if (arr[j][i] == 0) continue;
                // 같은 경우 합쳐져야한다. 두번 합쳐지면 안되므로, before 값은 다시 갱신해준다.
                if (arr[j][i] == before) {
                    arr[idx--][i] = before * 2;
                    before = 0;
                    arr[j][i] = 0;
                }
                // 다른 경우 왼쪽으로 이동시키고 before 값이 갱신되어야 한다.
                else {
                    if (before == 0) {
                        before = arr[j][i];
                        arr[j][i] = 0;
                    } else {
                        arr[idx--][i] = before;
                        before = arr[j][i];
                        arr[j][i] = 0;
                    }
                }
            }
            if (before != 0) {
                arr[idx][i] = before;
            }
        }
    }
}
