import java.util.ArrayList;
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
	static int[][] summap;
	static int r, c, t;

	static ArrayList<path> cleaner;
	static Queue<path> mise;

	static int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		t = sc.nextInt();

		map = new int[r][c];
		summap = new int[r][c];

		mise = new LinkedList<path>();
		cleaner = new ArrayList<path>();

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == -1) {
					cleaner.add(new path(i, j));
				} else if (map[i][j] > 0) {
					mise.add(new path(i, j));
				}
			}
		}

		while (t> 0 && !mise.isEmpty()) {
			int size = mise.size();
			for (int i = 0; i < size; i++) {
				path m = mise.poll();
				int cnt = 0;
				int divide = 0;
				for (int d = 0; d < 4; d++) {
					int nr = m.row + direction[d][0];
					int nc = m.col + direction[d][1];

					if (nr < 0 || nc < 0 || nr >= r || nc >= c || map[nr][nc] == -1)
						continue;

					divide = (int) (map[m.row][m.col] / 5);
					summap[nr][nc] += divide;
					cnt++;
				}
				map[m.row][m.col] = map[m.row][m.col] - divide * cnt;
			}

			sum();
		//	System.out.println("미세먼지 퍼짐");
		//	print();
			clean();
		//	System.out.println("미세먼지 이동");
		//	print();
			
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					if(map[i][j]>0) {
						mise.add(new path(i,j));
					}
				}
			}
			
			t--;
			
		}
		int sum=0;
		int size = mise.size();
		for(int i=0; i<size; i++) {
			path p = mise.poll();
			sum += map[p.row][p.col];
		}
		System.out.println(sum);

	}

	private static void print() {
		System.out.println("*************");
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				System.out.printf("%3d",map[i][j]);
			}
			System.out.println();
		}
		System.out.println("*************");
	}

	private static void sum() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] += summap[i][j];
				summap[i][j] = 0;
			}
		}

	}
	

	private static void clean() {
		
		path first = cleaner.get(0);
		path second = cleaner.get(1);

		int cr = first.row;
		int cc = first.col;
		
		int[] temp = new int[4];
		
		temp[0] = map[0][0];
		temp[1] = map[0][c-1];
		temp[2] = map[cr][0];
		temp[3] = map[cr][c-1];
		
		// 오른쪽
		for (int i = c - 1; i > cc + 1; i--) {
			map[cr][i] = map[cr][i - 1];
		}
		// 위쪽
		for (int i = 0; i < cr; i++) {
			map[i][c - 1] = map[i + 1][c - 1];
		}
		map[cr - 1][c - 1] = temp[3];
		// 왼쪽
		for (int i = cc; i < c - 1; i++) {
			map[0][i] = map[0][i + 1];
		}
		map[0][c - 2] = temp[1];
		// 아래쪽
		for (int i = cr - 2; i > 0; i--) {
			map[i+1][0] = map[i][0];
		}
		map[1][0] = temp[0];

		map[cr][cc + 1] = 0;

		cr = second.row;
		cc = second.col;

		temp[0] = map[cr][0];
		temp[1] = map[cr][c-1];
		temp[2] = map[r-1][0];
		temp[3] = map[r-1][c-1];
		
		// 오른쪽
		for (int i = c - 1; i > cc + 1; i--) {
			map[cr][i] = map[cr][i - 1];
		}
		// 아래쪽
		int downtmp = map[r-1][c-1];
		//cr -> r-1
		for (int i = r-2; i > cr; i--) {
			map[i+1][c-1] = map[i][c-1];
		}
		map[cr+1][c-1]=temp[1];
		
		// 왼쪽
		for (int i = cc; i < c - 2; i++) {
			map[r - 1][i] = map[r - 1][i + 1];
		}
		map[r-1][c-2] = temp[3];
		// 위쪽
		for (int i = cr; i < r-2; i++) {
			map[i][0] = map[i + 1][0];
		}
		map[r-2][0] =temp[2];
		map[cr][cc + 1] = 0;
		map[first.row][first.col] = -1;
		map[second.row][second.col] = -1;

	}

}
