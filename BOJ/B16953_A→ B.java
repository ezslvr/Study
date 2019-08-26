import java.util.Scanner;

public class Main {
	static boolean flag;
	static long b;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		b = sc.nextInt();
		dfs(a,1);
		if(!flag) System.out.println(-1);

	}

	private static void dfs(long a, int cnt) {
		if(a>b)return;
		if (a == b) {
			flag = true;
			System.out.println(cnt);
			return;
		}
		if (a < b) {
			dfs(a * 2, cnt + 1);
			dfs(a * 10 + 1, cnt + 1);
		}
	}
}
