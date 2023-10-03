

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[][] copyMap;
    static int[][] countRow;
    static int[][] countCol;
    static int num;
    static boolean[][] check;
    static int result;
    static boolean checkRow;

    public static void main(String[] args) throws IOException {
        input();
        for (int c = 0; c < 7; c++) {
            copy();
            for (int r = 6; r >= 0; r--) {
                if (map[r][c] == 0) {
                    map[r][c] = num;
                    break;
                }
            }
            while (true) {
                dropBall();
                rowCnt();
                colCnt();
                findSameRowNumber();
//                findSameColNumber();
                if (!checkRow) break;
                makeZero();
                dropBall();
//                if (c == 6) {
//                for (int[] list : map) {
//                    System.out.println(Arrays.toString(list));
//                }
//                System.out.println("===============EndRow");
//                for (int[] list : countCol) {
//                    System.out.println(Arrays.toString(list));
//                }
//                System.out.println("===============EndCol");
//                }

            }
//            System.out.println("현재값 : " + c + " 최솟값 : " + calculateMap());
            result = Math.min(result, calculateMap());

        }
        System.out.println(result);
    }

    // 배열복사
    private static void copy() {
        map = new int[7][7];
        for (int r = 0; r < 7; r++) {
            for (int c = 0; c < 7; c++) {
                map[r][c] = copyMap[r][c];
            }
        }
    }


    // 전체 갯수 세기
    private static int calculateMap() {
        int sum = 0;
        for (int r = 0; r < 7; r++) {
            for (int c = 0; c < 7; c++) {
                if (map[r][c] > 0) sum++;
            }
        }
        return sum;
    }

    // 공 재배치
    private static void dropBall() {
        for (int c = 0; c < 7; c++) {

            // 처음으로 0 나오는 위치 기억
            int firstZero = 6;
            boolean onlyFirstTime = false;
            for (int r = 6; r >= 0; r--) {
                if (!onlyFirstTime && map[r][c] == 0) {
                    firstZero = r;
                    onlyFirstTime = true;
                }
                // 중간에 0이 있었고, 1보다 큰 숫자라면 아래로 땡기기
                if (onlyFirstTime && map[r][c] > 0) {
                    map[firstZero][c] = map[r][c];
                    map[r][c] = 0;
                    firstZero--;
                }
            }
        }
    }

    // true인 친구 0으로 바꾸기
    private static void makeZero() {
        for (int r = 0; r < 7; r++) {
            for (int c = 0; c < 7; c++) {
                if (check[r][c]) map[r][c] = 0;
            }
        }
    }

    // 각 행과 열에 0보다 큰 숫자들과 자신의 숫자가 일치하면 true로 바꾸자.
    private static void findSameRowNumber() {
        checkRow = false;
        check = new boolean[7][7];
        for (int r = 0; r < 7; r++) {
            for (int c = 0; c < 7; c++) {
                if (map[r][c] != 0 && (map[r][c] == countRow[r][c] || map[r][c] == countCol[r][c])) {
                    check[r][c] = true;
                    checkRow = true;
                }
            }
        }
    }

//    private static void findSameColNumber() {
//        checkCol = false;
//        for (int c = 0; c < 7; c++) {
//            for (int r = 0; r < 7; r++) {
//                if (countCol[r][c] != 0 && map[r][c] == countCol[r][c]) {
//                    check[r][c] = true;
//                    checkCol = true;
//                }
//            }
//        }
//    }

    // 각 행의 갯수 세기 *** 연속되는 수 찾기
    private static void rowCnt() {
        countRow = new int[7][7];
        for (int r = 0; r < 7; r++) {
            int c = 0;
            while (c < 7) {
                if (map[r][c] > 0) {
                    int idx = 0;
                    int startC = c;
                    while (c < 7 && map[r][c] > 0) {
                        idx++;
                        c++;
                    }
                    for (int i = startC; i < startC + idx; i++) {
                        countRow[r][i] = idx;
                    }
                } else {
                    c++;
                }
            }
        }
    }

    // 각 열의 갯수 세기
    private static void colCnt() {
        countCol = new int[7][7];
        for (int c = 0; c < 7; c++) {
            int r = 0;
            while (r < 7) {
                if (map[r][c] > 0) {
                    int idx = 0;
                    int startR = r;
                    while (r < 7 && map[r][c] > 0) {
                        idx++;
                        r++;
                    }
                    for (int i = startR; i < startR + idx; i++) {
                        countCol[i][c] = idx;
                    }
                } else {
                    r++;
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        copyMap = new int[7][7];
        result = 646813;
        for (int r = 0; r < 7; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 7; c++) {
                copyMap[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        num = Integer.parseInt(br.readLine());
    }


}
