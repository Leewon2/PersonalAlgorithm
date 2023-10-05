import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int x = 0;
            for (int j = n; j >= 1; j--) {
                if (i < j) {
                    sb.append(" ");
                } else {
                    if (x == 0) {
                        sb.append("*");
                        x++;
                    } else {
                        sb.append(" *");

                    }
                }

            }

            sb.append("\n");
        }
        System.out.println(sb);

    }
}