import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        int startr=0;
        int startc=0;
        int endr=0;
        int endc=0;
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
                if(arr[r][c]==5){
                    startr = r;
                    startc = c;
                }
                if(arr[r][c]==2){
                    endr=r;
                    endc=c;
                }
            }
        }
        if(startr>endr){
            int temp = startr;
            startr = endr;
            endr = temp;
        }
        if(startc>endc){
            int temp = startc;
            startc = endc;
            endc = temp;
        }
        int cnt=0;
        for (int r = startr; r <= endr; r++) {
            for (int c = startc; c <= endc; c++) {
                if(arr[r][c]==1) cnt++;
            }
        }
        double dist = Math.sqrt((Math.pow(startr-endr,2)+Math.pow(startc-endc,2)));
//        System.out.println("startr : " + startr+" startc : " + startc+" endr : " + endr+" endc : " + endc);
        if(dist<5) System.out.println(0);
        else System.out.println(cnt >= 3 ? 1 : 0);



    }
//
}
/*
* 2143
* 3412
* */
