import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class animal{
		int r;
		int c;
		char ch;
		public animal(int r, int c, char ch) {
			super();
			this.r = r;
			this.c = c;
			this.ch = ch;
		}
	}

	static int[][] direction= {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();

		int ocnt=0;
		int vcnt=0;
		int oans=0;
		int vans=0;

		char[][] map = new char[R][C];
		Queue<animal> q = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];

		for(int i=0; i<R; i++) {
			map[i] = sc.next().toCharArray();
		}

		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]!='#' && !visited[i][j]) {
					q.add(new animal(i,j,map[i][j]));

					while(!q.isEmpty()) {
						animal a = q.poll();
						if(a.ch=='o') ocnt++; 
						else if(a.ch=='v') vcnt++;
						visited[a.r][a.c] =true;

						for(int d=0; d<4; d++) {
							int nr = a.r + direction[d][0];
							int nc = a.c + direction[d][1];

							if(nr<0||nc<0||nr>=R||nc>=C
									||visited[nr][nc]||map[nr][nc]=='#') continue;

							q.add(new animal(nr,nc,map[nr][nc]));
							visited[nr][nc] =true;
						}
					}

					if(ocnt<=vcnt) vans+=vcnt;
					else oans+=ocnt;

					ocnt=0;
					vcnt=0;
				}
			}
		}

		System.out.println(oans +" "+vans);
	}


}
