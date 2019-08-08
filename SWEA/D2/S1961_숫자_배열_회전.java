import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	static ArrayList<Integer>[] arr;
	static ArrayList<Integer>[] copy;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			arr = new ArrayList[n];
			copy = new ArrayList[n];

			for (int i = 0; i < n; i++) {
				arr[i] = new ArrayList<>();
				copy[i] = new ArrayList<>();
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i].add(sc.nextInt());
				}
			}

			rotate();
			for(int i=0; i<n; i++)
				arr[i].clear();
			rotate2();
			rotate();
			
			System.out.println("#"+tc);
			for(int i=0; i<n; i++) {
				for(int j=0; j<copy[i].size(); j++) {
					System.out.print(copy[i].get(j));
					if((j+1) % n ==0) System.out.print(" ");
				}
				System.out.println();
			}
			
		}
	}

	private static void rotate() {
		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j >= 0; j--) {
				copy[i].add(arr[j].get(i));
			}
		}
	}

	private static void rotate2() {
		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j >= 0; j--) {
				copy[i].add(copy[j].get(i));
				arr[i].add(copy[j].get(i));
			}
		}
	}



}
