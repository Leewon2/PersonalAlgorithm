import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int taesu = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        Integer[] arr;
        if(N!=0){
            arr = new Integer[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr,(o1,o2)->{
                return o2-o1;
            });
            for (int i = 0; i < arr.length; i++) {
                if(i>=P) break;
                if(i==P-1){
                    if(arr[i]<taesu){
                        System.out.println(P);
                    }else {
                        System.out.println(-1);
                    }
                }else{
                    if(arr[i]<taesu){
                        System.out.println(i+1);
                        break;
                    }else if(arr[i]==taesu){
                        int j=i;
                        while(j<arr.length){
                            if(arr[j++]<arr[i]){
                                break;
                            }
                        }
                        if(j<P){

                            System.out.println(i+1);
                            break;
                        }else if(j==P){
                            if(arr[P-1]<taesu) {
                                System.out.println(i+1);
                                break;
                            }
                            else{
                                System.out.println(-1);
                                break;
                            }
                        }
                    }
                }
                if(i==arr.length-1 && N<P){
                    System.out.println(i+2);
                    break;
                }
            }
            // 같은데 11111인경우

        }else{
            System.out.println(1);
        }




    }
//
}
/*
* 2143
* 3412
* */
