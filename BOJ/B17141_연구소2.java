import java.util.ArrayList;
import java.util.Arrays;
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
	static ArrayList<path> list;
	static int[][] map;
	static int[][] copymap;
	static int m,n,cnt,min;
	static boolean[] visited;
	static boolean[][] visited2;
	static int[] c;
	static int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n][n];
		copymap = new int[n][n];
		list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
				copymap[i][j] = map[i][j];
				if(map[i][j]==2) {
					list.add(new path(i,j));
				}
			}
		}
		min = Integer.MAX_VALUE;
		visited = new boolean[m];
		visited2 = new boolean[n][n];
		c = new int[m];
		combination(0,0);
		
		if(min==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min-1);
		
		
	}
	private static void combination(int index, int start) {
		if(index==m) {
			cnt=0;
			init();
			bfs();
			if(cnt != -1)
				min=Math.min(cnt, min);
			//System.out.println(Arrays.toString(c));
			return;
		}
		for(int i=start; i<list.size(); i++) {
			if(!visited[index]) {
				visited[index] = true;
				c[index] = i;
				combination(index+1, i+1);
				visited[index] = false;
			}
		}
	}
	private static void init() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j]= copymap[i][j];
			}
		}
	}
	private static void bfs() {
		Queue<path> q = new LinkedList<path>();
		for(int i=0; i<m; i++) {
			q.add(list.get(c[i]));
			map[list.get(c[i]).row][list.get(c[i]).col] = 3;
		}
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				path p =q.poll();
				for(int d=0; d<4; d++) {
					int dr=p.row + direction[d][0];
					int dc=p.col + direction[d][1];
					
					if(dr<0||dc<0||dr>=n||dc>=n||map[dr][dc]==1||map[dr][dc]==3) continue;
					map[dr][dc] = 3;
					q.add(new path(dr,dc));
				}
			}
			cnt++;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==0)
					cnt = -1;
			}
		}
	}

}
