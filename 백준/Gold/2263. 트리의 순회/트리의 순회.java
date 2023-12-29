

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] inorder;
    static int[] postorder;
    static int[] inorderIdx;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        input();
        conquer(1, N, 1, N);
        System.out.println(sb);
    }
    private static void conquer(int inStart, int inEnd, int postStart, int postEnd){
        if(inEnd<inStart || postEnd<postStart) return;
        int root = postorder[postEnd];
        int idx = inorderIdx[root];
        sb.append(root).append(" ");
        int len = idx - inStart;
        conquer(inStart, idx-1, postStart, postStart+len-1);
        conquer(idx+1, inEnd, postStart+len, postEnd-1);

    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        inorder = new int[N+1];
        postorder = new int[N+1];
        inorderIdx = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            inorderIdx[inorder[i]]=i;
        }

    }
}
