import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static class path{
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

	static Queue<path> q;
	static int n, m, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		q = new LinkedList<path>();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				map[i][j] = sc.nextInt();
			}
		}
		while (true) {
			int row = -1;
			int col = -1;
			con: for (int i = 0; i < n; ++i) {
				for (int j = 0; j < m; ++j) {
					if (map[i][j] == 1) {
						row = i;
						col = j;
						break con;
					}
				}
			}

			if (row == -1 && col == -1)
				break;
			outline();
			melting();
			ans++;
		}
		System.out.println(ans);
	}

	private static void melting() {
		int cnt=0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (map[i][j] == 1) {
					cnt=0;
					for(int d=0; d<4; d++) {
						int nr = i+direction[d][0];
						int nc = j+direction[d][1];
						if(nr<0||nc<0||nr>=n||nc>=m) continue;
						if(map[nr][nc]==-1) cnt++;
					}
					if(cnt>=2) map[i][j]=0;
				}
			}
		}
	}

	private static void outline() {
		q.clear();
		visited = new boolean[n][m];
		
		q.add(new path(0,0));
		visited[0][0]=true;
		while(!q.isEmpty()) {
			path p = q.poll();
			for(int i=0; i<4; i++) {
				int nr = p.row + direction[i][0];
				int nc = p.col + direction[i][1];
				if(nr<0||nc<0||nr>=n||nc>=m||visited[nr][nc]||map[nr][nc]==1) continue;
				map[nr][nc]=-1;
				visited[nr][nc]=true;
				q.add(new path(nr,nc));
			}
		}
	}

}
