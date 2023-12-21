import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N+1];
        for (int i = 0; i <= N; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            change(x,y, arr);
        }
//        System.out.println(Arrays.toString(arr));
        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i]+" ");
        }


    }
    private static void change(int x, int y, int[] arr){
        for (int i = 0; i <= (y-x)/2; i++) {
            int temp = arr[x+i];
            arr[x+i] = arr[y-i];
            arr[y-i]=temp;
        }
    }
}
/*
* 2143
* 3412
* */
