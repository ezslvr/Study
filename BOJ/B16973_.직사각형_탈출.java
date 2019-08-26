import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class path {
		int row;
		int col;
		int cnt;

		public path(int row, int col, int cnt) {
			super();
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "path [row=" + row + ", col=" + col + "]";
		}
		
	}
	static int n,m,smalln,smallm;
	static int[][] map;
	static boolean[][] visited;
	static boolean flag;
	static Queue<path> q;
	static int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visited = new boolean[n][m];
		q = new LinkedList<path>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		path[] p = new path[2];
		
		smalln = sc.nextInt();
		smallm = sc.nextInt();
		p[0] = new path(sc.nextInt()-1,sc.nextInt()-1,0);
		p[1] = new path(sc.nextInt()-1,sc.nextInt()-1,0);
		
		q.add(new path(p[0].row,p[0].col,0));
		visited[p[0].row][p[0].col] =true;
		while(!q.isEmpty()) {
			path cur = q.poll();
			if(cur.row == p[1].row && cur.col == p[1].col) {
				System.out.println(cur.cnt);
				flag = true;
				return;
			}
			for(int i=0; i<4; i++) {
				int nr =cur.row + direction[i][0]; 
				int nc =cur.col + direction[i][1];
				
				if(nr<0||nc<0||nr>=n||nc>=m||visited[nr][nc])continue;
				if(move(nr,nc,i)) {
					visited[nr][nc] =true;
					q.add(new path(nr,nc,cur.cnt+1));
				}
			}
			
		}
		
		if(!flag) System.out.println(-1);
		
	}
	private static boolean move(int nr, int nc, int d) {
		int row =0;
		int col =0;
		if(d==0) { //ºÏ
			row = nr;
			for(int i=nc; i<nc+smallm; i++)
			if (row>=n||i>=m||map[row][i] == 1) return false;
		}else if(d==1) { //³²
			row = nr+smalln-1;
			for(int i=nc; i<nc+smallm; i++)
			if (row>=n||i>=m||map[row][i] == 1) return false;
			
		}else if(d==2) { //µ¿
			col = nc+smallm-1;
			for(int i=nr; i<nr+smalln; i++)
				if (i>=n||col>=m||map[i][col] == 1) return false;
		}else { //¼­
			col = nc;
			for(int i=nr; i<nr+smalln; i++)
				if (i>=n||col>=m||map[i][col] == 1) return false;
		}

		return true;
	}

}
