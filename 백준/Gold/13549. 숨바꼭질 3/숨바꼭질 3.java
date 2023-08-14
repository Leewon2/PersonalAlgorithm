import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static Queue<Integer> q = new LinkedList<>();
	static int root=1;
	static int poll;
	static int cnt=1;
	static int[] check = new int[100001];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int subin = sc.nextInt();
		int sister = sc.nextInt();
		q.offer(subin);
		check[subin]=cnt;
		bfs(sister);
	}

	public static void bfs(int data) {

		// 동생과 만날때 까지 가보자.
		outer: while (true) {
			poll = q.poll();
			cnt = check[poll];
			if (poll - 1 >= 0) {
				if (check[poll - 1] == 0 || check[poll - 1] > cnt+1) {
					q.offer(poll - 1);
					check[poll - 1] = cnt + 1;
				}
			}

			if (poll * 2 < 100001) {
				if (check[poll * 2] == 0 || check[poll * 2] > cnt ) {
					q.offer(poll * 2);
					check[poll * 2] = cnt;

				}

			}


			if (poll + 1 < 100001) {
				if (check[poll + 1] == 0 || check[poll + 1] > cnt+1) {
					q.offer(poll + 1);
					check[poll + 1] = cnt + 1;

				}

			}

//				System.out.print("현재 꺼낸 값 : " + poll + " 현재 root : "+root + " 현재 cnt : "+cnt + " 해당 check값 : " + check[poll]);
			if (poll == data) {
				System.out.println(check[poll]-1);
				break outer;

			}
//				System.out.println();

		}

	}
}
