import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] arr2 = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(arr,arr2,0,N-1);
        System.out.println(arr[K - 1]);
    }

    public static void mergeSort(int[] arr1, int[] arr2, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr1,arr2, start, mid);
            mergeSort(arr1,arr2, mid + 1, end);
            int p = start;
            int q = mid + 1;
            int idx = p;
            while (p <= mid || q <= end) {
                if (q > end || (p <= mid && arr1[p] < arr1[q])) {
                    arr2[idx++] = arr1[p++];
                } else {
                    arr2[idx++] = arr1[q++];
                }
            }
            for (int i = start; i <= end; i++) {
                arr1[i] = arr2[i];
            }
        }
    }

}


//
/*
 * 2143
 * 3412
 * */
