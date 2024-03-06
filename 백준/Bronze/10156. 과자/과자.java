import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int price = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        int sum = price*cnt;
        int money = Integer.parseInt(st.nextToken());
        System.out.println(Math.max(sum - money, 0));
    }
}
