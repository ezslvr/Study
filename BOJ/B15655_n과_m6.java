import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int n,m;
	static int[] arr,ans;
	static boolean visited[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); 
		m = sc.nextInt();
		arr = new int[n];
		ans = new int[m];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		dfs(0,0);
	}
	private static void dfs(int index, int start) {
		if(index >= m) {
			for(int i : ans) {
				System.out.print(i+ " ");
			}
			System.out.println();
			return;
		}
		for(int i=start; i<n; i++) {
			ans[index] = arr[i];
			dfs(index+1,i+1);
		}
	}

}