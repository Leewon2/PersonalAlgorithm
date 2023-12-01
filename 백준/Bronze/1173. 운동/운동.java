import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        if(m+T>M) System.out.println(-1);


        else{
            int cnt=0;
            int now=m;
            while(N>0){
                if(now+T<=M){
                    now+=T;
                    N--;
                }else {
                    if(now-R>=m){
                        now-=R;

                    }
                    else{
                        now=m;
                    }

                }
                cnt++;
            }
            System.out.println(cnt);
        }


    }
}

