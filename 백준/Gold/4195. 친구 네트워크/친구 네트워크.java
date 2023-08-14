

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static int F;

	static int[] parentList;

	static int[] rankList;

	static int count;

	// 해시맵을 이용해 String 값을 입력 받고 숫자를 부여하자.


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);

		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			// 친구 관계 수를 입력 받자.
			Map<String, Integer> hash = new HashMap<>();
			F = Integer.parseInt(br.readLine());

			// 문자를 숫자로 바꿔줄꺼다.
			parentList = new int[F * 2];
			rankList = new int[F * 2];

			count = 0;
			make();
			for (int i = 0; i < F; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name1 = st.nextToken();
				String name2 = st.nextToken();
				if (!hash.containsKey(name1)) {
					// hash에 이름과 count를 put 해주자.
					hash.put(name1, count++);
					// 숫자 값만 얻고 싶으므로,,,
					// 첫번째 이름은 arr[count-1][0]
				}
				// 해당 이름이 존재하면???
					// 이름에 저장된 count 값을 저장하자.

				if (!hash.containsKey(name2)) {
					hash.put(name2, count++);
				}

				System.out.println(union(hash.get(name1),hash.get(name2)));
			}

//			for(int[] list :arr) {
//				System.out.println(Arrays.toString(list));
//			}

			// 부모가 같은지 확인해보자.
//			for (int i = 0; i < arr.length; i++) {
//				int x = arr[i][0];
//				int y = arr[i][1];
//				if (find(x) != find(y)) {
//					union(x, y);
//				}
////				System.out.println(i+1 + " x : " + x + " y : "+y);
////				System.out.println("findX : "+find(x));
////				System.out.println("findY : "+find(y));
//				// 겹치지 않게 방문체크를 해주자.
//				boolean[] check = new boolean[F * 2 + 2];
//
//				check[x] = check[y] = true;
//
//				// 뽑은 2개는 무조건 포함이므로 cnt를 2로 시작하자.
//				int cnt = 2;
//
//				// union을 하고 갯수를 부모가 같은 갯수를 세어봐야겠지?
//				for (int j = 0; j < i; j++) {
//					int a = arr[j][0];
////					System.out.println(check[a]);
//					int b = arr[j][1];
//					if (parentList[x] != parentList[a] && parentList[x] != parentList[b])
//						continue;
////					System.out.println(j+1 + " a : " + a + " b : "+b);
////					System.out.println(check[b]);
////					System.out.println(check[b]);
////					System.out.println(find(x)==find(a));
////					System.out.println(find(y)==find(a));
////					if (parentList[x] == parentList[a]) {
////						System.out.println("WOW");
//					parentList[a] = parentList[x];
//					parentList[b] = parentList[x];
//					if (x != a && y != a && !check[a]) {
//						cnt++;
//						check[a] = true;
//					}
////					}
////					if (parentList[x] == parentList[b]) {
////					parentList[a] = parentList[x];
////					parentList[b] = parentList[x];
//					if (x != b && y != b && !check[b]) {
//						cnt++;
//						check[b] = true;
//					}
////					}
//				}
////				System.out.println(Arrays.toString(parentList));
//				System.out.println(cnt);
//
//			}

		}
		br.close();
	}

	private static void make() {
		// TODO Auto-generated method stub
		for (int i = 0; i <F*2; i++) {
			parentList[i] = i;
			rankList[i] = 1;
		}
	}

	private static int find(int idx) {
		// TODO Auto-generated method stub
		if (parentList[idx] == idx)
			return idx;
		else {
			return parentList[idx] = find(parentList[idx]);
		}
	}

	private static int union(int x, int y) {

		int e1 = find(x);
		int e2 = find(y);
		// TODO Auto-generated method stub
		if (e1 != e2) {

			parentList[e2] = e1;
			rankList[e1] += rankList[e2];
			rankList[e2] = 1;
		}
		return rankList[e1];

	}

//		else {
//			parentList[e1] = e2;
//			if (rankList[e1] == rankList[e2]) {
//				rankList[e2]++;
//			}
//		}

}
