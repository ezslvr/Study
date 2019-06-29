import java.util.Scanner;

public class Main {

	static class path{
		int r;
		int c;
		int di;
		public path(int r, int c, int di) {
			super();
			this.r = r;
			this.c = c;
			this.di = di;
		}
		@Override
		public String toString() {
			return "path [r=" + r + ", c=" + c + ", di=" + di + "]";
		}
	}
	static int[][] di = {{0,1},{-1,0},{0,-1},{1,0}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			
			path p = new path(0,0,0);

			int maxr=Integer.MIN_VALUE;
			int maxc=Integer.MIN_VALUE;
			int minr=Integer.MAX_VALUE;
			int minc=Integer.MAX_VALUE;
			
			minr=Math.min(p.r,minr);
			minc=Math.min(p.c,minc);
			maxr=Math.max(p.r,maxr);
			maxc=Math.max(p.c,maxc);
			
			String comm = sc.next();
			int size = comm.length(); //4
			
			for(int i=0; i<size; i++) {
				char ch = comm.charAt(i); //FFLF
				
				int nr=p.r;
				int nc=p.c;
				if(ch=='F') { //한눈금 앞으로
					nr=p.r+di[p.di][0];
					nc=p.c+di[p.di][1];
				}
				else if(ch=='B') {
					nr=p.r-di[p.di][0];
					nc=p.c-di[p.di][1];
				}
				else if(ch=='L') {
					if(++p.di>=4) p.di=0;
				}
				
				else if(ch=='R') {
					if(--p.di<0) p.di=3;
				}
				
				minr=Math.min(nr,minr);
				minc=Math.min(nc,minc);
				maxr=Math.max(nr,maxr);
				maxc=Math.max(nc,maxc);
				
				p.r=nr;
				p.c=nc;
			}
			System.out.println((maxr-minr)*(maxc-minc));
		}
	}

}
