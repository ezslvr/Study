import java.util.Scanner;

public class Solution {

	static int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int n = sc.nextInt();
			int count = 1;
			boolean[][] map = new boolean[n][n];
			int[][] arr = new int[n][n];
			int nx,ny,x = 0,y=0;
			
			arr[x][y]=count;
			map[x][y]=true;
			int i;
			while(count<n*n) {
				for(i=0; i<4; i++) {
					nx = x + direction[i][0];					
					ny = y + direction[i][1];
					if(nx<0||ny<0||nx>=n||ny>=n||map[nx][ny]) continue;
					x = nx;
					y = ny;
					arr[x][y] = ++count; 
					map[x][y] = true;
					i--;
				}
				i=0;
			}
			
			System.out.println("#"+tc);
			for(int[] k: arr) {
				for(int j: k) {
					System.out.print(j+" ");
				}
				System.out.println();
			}
		}
	}

}
