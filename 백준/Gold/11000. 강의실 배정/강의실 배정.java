import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		Lecture[] lectures = new Lecture[N];
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			String[] sarr = br.readLine().split(" ");
			int s = Integer.parseInt(sarr[0]);
			int e = Integer.parseInt(sarr[1]);

			lectures[i] = new Lecture(s, e);
		}
		Arrays.sort(lectures);

		pq.offer(lectures[0].end);

		for (int i = 1; i < N; i++) {

			if (lectures[i].start >= pq.peek())
				pq.poll();

			pq.offer(lectures[i].end);
		}

		bw.write(pq.size() + "\n");
		bw.flush();

	}

	static class Lecture implements Comparable<Lecture> {

		int start, end;

		Lecture(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Lecture o) {

			if (start == o.start)
				return end - o.end;

			return start - o.start;
		}
	}

}