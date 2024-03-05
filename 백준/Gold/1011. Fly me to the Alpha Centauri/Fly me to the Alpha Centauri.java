import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int d = Y - X;
            int dist = (int) Math.sqrt(d);
            if (d == dist * dist) {
                sb.append(2 * dist - 1).append("\n");
            } else if (d <= dist * dist + dist) {
                sb.append(2 * dist).append("\n");
            }else{
                sb.append(2 * dist + 1).append("\n");
            }
        }
        System.out.println(sb);

    }
}
