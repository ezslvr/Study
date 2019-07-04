import java.util.Scanner;

public class Main {

	static int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int[][] snail = new int[M][N];
		boolean[][] visited = new boolean[M][N];
		
		snail[0][0]=1;
		visited[0][0] = true;
		int cnt=1;
		int ans =0;
		int sx=0;
		int sy=0;
		
	con:	while(cnt<M*N) {
			for(int i=0; i<4;) {
				//1. 일단 오른쪽
				int nx = sx + di[i][0];
				int ny = sy + di[i][1];

				//2.벽이거나 방문한 곳이면 회전
				if(nx<0||ny<0||nx>=M||ny>=N||visited[nx][ny]) { 
					ans++; i++; 
					if(i==4) i=0;
					continue;
				}
				
				cnt++;
				sx = nx;
				sy = ny;
				visited[sx][sy]=true;
				
				if(cnt>=M*N) break con;
				
			}
		}
		
		System.out.println(ans);
		
	}

}
