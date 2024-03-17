import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        int width=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-1; j++) {
                if(arr[i][j]=='.'){
                    if(arr[i][j+1]=='.'){
                        width++;
                        int k = j;
                        while(k<N){
                            if(arr[i][k]=='.'){
                                k++;
                            }else{
                                j=k;
                                break;
                            }
                            j=k;
                        }
                    }
                }
            }
        }
        int height=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-1; j++) {
                if(arr[j][i]=='.'){
                    if(arr[j+1][i]=='.'){
                        height++;
                        int k = j;
                        while(k<N){
                            if(arr[k][i]=='.'){
                                k++;
                            }else{
                                j=k;
                                break;
                            }
                            j=k;
                        }
                    }
                }
            }
        }
        System.out.println(width+" "+height);
    }
}
