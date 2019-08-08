import java.util.Arrays;
import java.util.Scanner;

public class Solution {
static class path {
	int s;
	int e;
	public path(int s, int e) {
		super();
		this.s = s;
		this.e = e;
	}
	
}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			sc.nextInt();
			int[] arr = new int[101];
			
			for(int i=0; i<1000; i++) {
				arr[sc.nextInt()]++;
			}
			path max = new path(0,0);
			for(int i=0; i<101; i++) {
				if(max.e <arr[i]) {
					max.e = arr[i];
					max.s = i;
				}
				else if(max.e == arr[i]) {
					if(max.s < i) {
						max.e = arr[i];
						max.s = i;
						
					}
				}
			}
			
			System.out.println("#"+tc+" "+max.s);
			
		}
	}

}
