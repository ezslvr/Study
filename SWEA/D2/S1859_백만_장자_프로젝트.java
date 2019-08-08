import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class S1859 {

	//1859. 백만 장자 프로젝트
/*
	3
	3
	10 7 6
	3
	3 5 9
	5
	1 1 3 1 2
	#1 0
	#2 10
	#3 5
	*/
	
	static int n,T,max;
	static long sum;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			sum=0;
			n = sc.nextInt();
			arr = new int[n];
			for(int i=0; i<n; i++) {
				arr[i]=sc.nextInt();
			}
			max = 0;
			for(int cur= n-1; cur>=0; cur--) {
				if(max > arr[cur])
					sum += max - arr[cur];
				else 
					max = arr[cur];
			}
				
			System.out.println("#"+tc+" "+sum);
		}
	}

}
