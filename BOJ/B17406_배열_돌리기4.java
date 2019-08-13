import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int n, m, k,sum;
	static int ans = Integer.MAX_VALUE;
	static int[][] map;
	static int[][] init_map;
	static int[] arr;
	static boolean[] visited;
	static path[] rotate_arr;
	static class path{
		int row;
		int col;
		int s;
		public path(int row, int col, int s) {
			super();
			this.row = row;
			this.col = col;
			this.s = s;
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		arr = new int[k];
		visited = new boolean[k];
		map = new int[n][m];
		init_map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				init_map[i][j] = map[i][j];
			}
		}
		rotate_arr = new path[k]; 
		for (int i = 0; i < k; i++) {
			rotate_arr[i] = new path(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		permu(0);
		//rotate();
	
		System.out.println(ans);
	}

	private static void permu(int index) {
		if(index==k) {
			init();
			for(int i=0; i<k; i++) {
				path p =rotate_arr[arr[i]];
				rotate(p.row,p.col,p.s);
			}
			sum();
		}
		for(int i=0; i<k; i++) {
			if(!visited[i]) {
				visited[i]=true;
				arr[index] = i;
				permu(index+1);
				visited[i]=false;
			}
		}
		
	}

	private static void init() {
		for(int j=0; j<n; j++)
			map[j] = Arrays.copyOf(init_map[j], m);
	}

	private static void sum() {
		for(int i=0; i<n; i++) {
			sum = 0;
			for(int j=0; j<m; j++) {
				sum += map[i][j];
			}
			ans = Math.min(sum, ans);
		}
	}

	private static void rotate(int row, int col, int s) {
		// System.out.println(row+" "+col+" "+s);

		for (int cnt = 0;; cnt++) {
			
			int sr = row - s -1 + cnt;
			int sc = col - s -1 + cnt;
			int er = row + s -1 - cnt;
			int ec = col + s -1 - cnt;

			if (sr == er && sc == ec)
				return;

			int temp = map[er][ec];

			for (int i = er; i > sr; i--) { // 1,6 - >2,6
				map[i][ec] = map[i - 1][ec];
			}
			for (int i = ec; i > sc; i--) {
				map[sr][i] = map[sr][i - 1];
			}
			for (int i = sr; i < er; i++) {
				map[i][sc] = map[i + 1][sc];
			}
			for (int i = sc; i < ec; i++) {
				map[er][i] = map[er][i + 1];
			}
			map[er][ec - 1] = temp;
		}

	}

}
