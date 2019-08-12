import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S2805 {

	//2805. 농작물 수확하기
	static int T;
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static Queue<path> q;
	static int ans;
	static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
	static class path {
		int row;
		int col;
		int num;
		public path(int row, int col, int num) {
			super();
			this.row = row;
			this.col = col;
			this.num = num;
		}
		@Override
		public String toString() {
			return "path [row=" + row + ", col=" + col + ", num=" + num + "]";
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			map = new int[n][n];
			visited = new boolean[n][n];
			for(int i=0; i<n; i++) {
				String[] input = sc.next().split("");
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
			}
			q = new LinkedList<path>();
			int start = (n-1)/2;
			q.add(new path(start,start,map[start][start]));
			ans = map[start][start];
			visited[start][start]= true;
			while(!q.isEmpty()) {
				if(visited[start][0] && visited[start][n-1] && visited[0][start]&&visited[n-1][start]) break;
				path curr = q.poll();
				for(int i=0; i<4; i++) {
					int nr = curr.row + direction[i][0];
					int nc = curr.col + direction[i][1];
					
					if(nr<0 || nr>= n || nc <0 || nc>= n ||visited[nr][nc]) continue;
					
					visited[nr][nc] = true;
					//print();
					ans += map[nr][nc];
					if(nr==0 || nc ==0 || nc== n-1 || nr==n-1) continue;
					q.add(new path(nr, nc, map[nr][nc]));
					
				}
			}
			
			System.out.println("#"+t+" " + ans);
		}
	}
	private static void print() {
		System.out.println("---------------------");
		for(boolean[] a: visited) {
			for(boolean b : a) {
				System.out.print(b);
			}
			System.out.println();
		}
	}

}
