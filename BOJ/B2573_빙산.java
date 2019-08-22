import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
	static int ans; 
	static int n, m;
	static int[][] map;
	static int[][] copymap;
	static int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		copymap = new int[n][m];
		boolean flag = false;
		Queue<path> q = new LinkedList<path>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]>0) q.add(new path(i,j));
			}
		}
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0; s<size; s++) {
				path p = q.poll();
				for(int i=0; i<4; i++) {
					int nr = p.row + direction[i][0];
					int nc = p.col + direction[i][1];
					
					if(nr<0||nc<0||nr>=n||nc>=m) continue;
					
					if(map[nr][nc]<=0) copymap[p.row][p.col]++;
				}
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(copymap[i][j]>0) {
						map[i][j] -= copymap[i][j];
						copymap[i][j] = 0;
					}
					if(map[i][j]>0)  q.add(new path(i,j));
				}
			}
			ans++;
			if(check()!=q.size()) {
				flag = true;
				break;
			}
		}
		
		if(!flag) ans = 0;
		System.out.println(ans);
		
		
		
	}
	private static int check() {
		boolean[][] visited = new boolean[n][m];
		Queue<path> list = new LinkedList<>();
		int cnt =0;
		con: for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]>0) {
					list.add(new path(i,j));
					cnt =1;
					break con;
				}
			}
		}
		while(!list.isEmpty()) {
			path p = list.poll();
			visited[p.row][p.col]=true;
			for(int i=0; i<4; i++) {
				int nr = p.row + direction[i][0]; 
				int nc = p.col + direction[i][1]; 
				if(nr<0 || nc<0 || nr>=n||nc>=m|| visited[nr][nc] || map[nr][nc]<=0) continue;
				list.add(new path(nr,nc));
				visited[nr][nc]=true;
				cnt++;
			}
		}
		return cnt;
	}
}
