

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9][9];
        check=false;
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs();


    }
    private static void print(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void dfs(){
        check = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(arr[i][j]==0){
                    for (int k = 1; k <= 9; k++) {
                        if(checkBox(i,j,k) && checkWidth(i,k) && checkHeight(j,k)) {
                            check=true;
                            arr[i][j]=k;
                            if(i==8 && j==8){
                                print();
                                System.exit(0);
                            }
                            dfs();
                            check=false;
                            arr[i][j]=0;
                        }
                    }
                    if(!check) return;
                }
                if(i==8 && j==8){
                    print();
                    System.exit(0);
                }
            }
        }
    }

    //가로 체크, 세로 체크, 3*3체크
    private static boolean checkWidth(int r, int num){
        for (int i = 0; i < 9; i++) {
            if(arr[r][i]==num) return false;
        }
        return true;
    }
    private static boolean checkHeight(int c, int num){
        for (int i = 0; i < 9; i++) {
            if(arr[i][c]==num) return false;
        }
        return true;
    }
    private static boolean checkBox(int r, int c, int num){
        int startR=returnRowAndCol(r);
        int startC=returnRowAndCol(c);
        for (int i = startR; i < startR + 3; i++) {
            for (int j = startC; j < startC + 3; j++) {
                if(arr[i][j]==num) return false;
            }
        }
        return true;
    }
    private static int returnRowAndCol(int x){
        if(x<=2) x=0;
        else if(x<=5) x=3;
        else x=6;
        return x;
    }
}
