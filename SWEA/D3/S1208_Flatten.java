import java.util.Arrays;
import java.util.Scanner;

public class S1208 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int t=1; t<=T; t++) {
			int cnt = sc.nextInt(); //´ýÇÁÈ½¼ö
			int[] arr = new int[100];
			
			for(int i=0; i<100; i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			for(int i=0; i<cnt; i++) {
				if(arr[99]-arr[0]==0 || arr[99]-arr[0]==1) break;
				arr[99]--;
				arr[0]++;
				Arrays.sort(arr);
			}
			
			System.out.println("#"+t+" "+ (arr[99]-arr[0]));
		}
	}

}
