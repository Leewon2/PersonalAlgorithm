
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int J = sc.nextInt();
        int[] arr= new int[J];
        int start=1;
        int end = start + M - 1;
        int res=0;
        for (int i = 0; i < J; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < J; i++) {
            if(arr[i]<start){
                res+=start-arr[i];
                start=arr[i];
                end=arr[i]+M-1;
            }else if(arr[i]>end){
                res+=arr[i]-end;
                end=arr[i];
                start=arr[i]-M+1;
            }
//            System.out.println("start : "+start + " end : "+end + " res : "+ res);
        }
        System.out.println(res);
    }
}
