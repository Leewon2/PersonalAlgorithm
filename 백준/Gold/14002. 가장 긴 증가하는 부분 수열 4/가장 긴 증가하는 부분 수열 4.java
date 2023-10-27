

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int[] intDp;
    static List<List<Integer>> listDp;
    static int max;


    public static void main(String[] args) throws IOException {
        input();
        System.out.println(calculate());
    }

    private static StringBuilder calculate(){
        StringBuilder sb = new StringBuilder();
        max=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j]<arr[i]){
                    if(intDp[i]<intDp[j]+1) {
                        intDp[i] = intDp[j] + 1;
                        listDp.set(i, new ArrayList<>(listDp.get(j)));
                        listDp.get(i).add(arr[i]);
                    }
                }
            }
            max = Math.max(max, intDp[i]);
        }
        System.out.println(max);

        for (int i = 0; i < N; i++) {
            if (intDp[i] == max) {
                for (int j = 0; j < listDp.get(i).size(); j++) {
                    sb.append(listDp.get(i).get(j)).append(" ");
                }
                break;
            }
        }
        return sb;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr =new int[N];
        intDp = new int[N];
        listDp = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            listDp.add(new ArrayList<>());
            listDp.get(i).add(arr[i]);
            intDp[i]=1;
        }

    }
}
