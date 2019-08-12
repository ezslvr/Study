import java.util.Arrays;
import java.util.Scanner;

public class S2817 {

	static int T,n,k;
	static int[] arr;
	static int[] ans;
	static int cnt;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			n = sc.nextInt();
			k = sc.nextInt();
			arr = new int[n];
			ans = new int[n];
			visited = new boolean[n+1];
			cnt = 0;
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			//4c0 4c1 4c2 4c3 4c4
			for(int i=1; i<=n; i++) {
				combination(0,0,i);
			}
			System.out.println("#"+ t+" "+ cnt);
		}
	}
	private static void combination(int index,int start,int m) {
		if(index == m) {
			int sum =0;
			//System.out.println(Arrays.toString(ans));
			for(int i=0; i<m; i++) {
				sum+=arr[ans[i]];
			}
			if(sum==k) {
				//System.out.println(Arrays.toString(ans));
				cnt++;
			}
			return;
		}
		
		for(int i=start; i<n; i++) {
			if(!visited[i]) {
				ans[index] = i;
				visited[i] = true;
				combination(index+1,i,m);
				visited[i] = false;
			}
		}
		
	}

}
