

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return Integer.compare(o2.getV(), o1.getV()); // right를 기준으로 내림차순 정렬
			}
		});
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long result=0;
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		ArrayList<Node> jewel = new ArrayList<>();
		ArrayList<Integer> bag = new ArrayList<>();
		
		
		// 보석의 무게와 값어치 입력받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jewel.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		// 가방 정보 입력받기
		for (int i = 0; i < K; i++) {
			bag.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(jewel, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.getM(), o2.getM());
			}
		});
		Collections.sort(bag);
		int idx=0;
		
		
		for(int i=0; i<K; i++) {
			while(idx<N && jewel.get(idx).getM()<=bag.get(i)) {
				pq.offer(jewel.get(idx++));
			}
			if(!pq.isEmpty()) result+=pq.poll().getV();
		}
		
		
		System.out.println(result);
		
		
	}

	static class Node {
		int m;
		int v;

		public Node(int m, int v) {
			this.m = m;
			this.v = v;
		}

		public int getM() {
			return m;
		}

		public int getV() {
			return v;
		}

	}
}
