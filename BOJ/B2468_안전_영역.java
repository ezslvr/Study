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

	static int[][] map;
	static int n;
	static int ans=1;
	static boolean[][] visited;
	static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		int h = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
				h = Math.max(h, map[i][j]);
			}
		}
		
		for(int i=1; i<h; i++) {
			rain(i);
			int cnt =0;
			visited = new boolean[n][n]; 
			while(true) {
				int row =-1;
				int col =-1;
				con: for(int in=0; in<n; in++) {
					for(int j=0; j<n; j++) {
						if(map[in][j]>0 && !visited[in][j]) {
							row = in;
							col = j;
							visited[in][j] = true;
							break con;
						}
					}
				}
				if(row==-1 && col==-1) break;
				checkMaxArea(row,col);
				cnt++;
			}
			ans = Math.max(ans, cnt);
		}
		
		System.out.println(ans);
		
	}

	private static void checkMaxArea(int row, int col) {
		Queue<path> q = new LinkedList<path>();
		q.add(new path(row,col));
		while(!q.isEmpty()) {
			path p =q.poll();
			for(int i=0; i<4; i++) {
				int nr = p.row + direction[i][0];
				int nc = p.col + direction[i][1];
				if(nr<0||nc<0||nr>=n||nc>=n||visited[nr][nc]||map[nr][nc]<=0) continue;
				q.add(new path(nr,nc));
				visited[nr][nc]=true;
			}
			
		}
		
	}


	private static void rain(int h) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j]-= 1;
			}
		}
	}

}
