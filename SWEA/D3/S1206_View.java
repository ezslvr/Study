import java.util.Scanner;

public class S1206 {

	//1206. [S/W 문제해결 기본] 1일차 - View
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int sum = 0;
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i=2; i<n-2; i++) {
				int remain = arr[i]-max(arr[i-2], arr[i-1], arr[i+1], arr[i+2]);
				if(remain<0) continue;
				else sum +=remain;
			}
			
			System.out.println("#"+t+" "+sum);
		}
	}

	private static int max(int i, int j, int k, int l) {
		int max = i;
		max = Math.max(max, j);
		max = Math.max(max, k);
		max = Math.max(max, l);
		return max;
	}

}
