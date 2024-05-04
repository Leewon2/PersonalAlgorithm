import java.util.Scanner;

public class Main {
    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        res = 0;
        dfs(n);
        System.out.println(res);
    }

    private static void dfs(int k) {
        if (k == 1) {
            return;
        }

        if (k % 2 == 0) {
            res += ((k / 2) * (k / 2));
            dfs(k / 2);
            dfs(k / 2);
        } else {
            res += ((k / 2) * (k / 2 + 1));
            dfs(k / 2);
            dfs(k / 2 + 1);
        }
    }
}
