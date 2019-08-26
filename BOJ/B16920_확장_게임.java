import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static class path {
		int row;
		int col;

		public path(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "path [row=" + row + ", col=" + col + "]";
		}

	}

	static Queue<path> q[];
	static int n, m, p;
	static int[] s, ans;
	static boolean visited[][];
	static boolean flag = false;
	static int[][] map;
	static int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {

		init();

		while (!flag) {
			int cnt =0;
			for (int i = 1; i < p + 1; i++) {
				if (q[i].isEmpty()) {
					cnt++;
				}
			}
			if (cnt==p) {
				flag = true;
				break;
			}
			
			for (int i = 1; i < p + 1; i++) {

				go(i);

			}

		}

		print();

	}

	private static void print() {
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (map[i][j] > 0)
					ans[map[i][j]]++;
			}
		}

		for (int i = 1; i < p + 1; ++i) {
			System.out.print(ans[i] + " ");
		}
	}

	private static void go(int index) {

		for (int j = 0; j < s[index]; ++j) { // 2Ä­°¡´Â °æ¿ì
			 if(q[index].isEmpty()) {
		            return;
		         }
			int size = q[index].size();
			for (int i = 0; i < size; ++i) {
				path c = q[index].poll();
				int nr = 0;
				int nc = 0;
				for (int d = 0; d < 4; ++d) {
					nr = c.row + direction[d][0];
					nc = c.col + direction[d][1];
					if (nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc])
						continue;

					if (map[nr][nc] == 0) {
						q[index].add(new path(nr, nc));
						visited[nr][nc] = true;
						map[nr][nc] = index;
					}
				}

			}
		}
	}

	private static void init() throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] inpu = in.readLine().split(" ");
		n = Integer.parseInt(inpu[0]);
		m = Integer.parseInt(inpu[1]);
		p = Integer.parseInt(inpu[2]);
		map = new int[n][m];
		visited = new boolean[n][m];
		s = new int[p + 1];
		ans = new int[p + 1];
		q = new LinkedList[p + 1];

		for (int i = 0; i < p + 1; ++i) {
			q[i] = new LinkedList<path>();
		}

		inpu = in.readLine().split(" ");
		for (int i = 1; i < p + 1; ++i) {
			s[i] = Integer.parseInt(inpu[i-1]);
		}

		for (int i = 0; i < n; ++i) {
			char[] input = in.readLine().toCharArray();
			for (int j = 0; j < m; ++j) {
				if (input[j] == '.') {
					map[i][j] = 0;
				} else if (input[j] == '#') {
					map[i][j] = -1;
				} else {
					map[i][j] = input[j] - '0';
					q[map[i][j]].add(new path(i, j));
				}
			}
		}
	}

}