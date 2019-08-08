import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int[][] map;
	static int[] nine = new int[10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			map = new int[9][9];
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			System.out.print("#"+ tc+" ");
			
			if(check_row() && check_height() && check_square())
				System.out.println(1);
			else
				System.out.println(0);
			
		}
	}
	private static boolean check_row() {
		for(int i=0; i<9; i++) {
			Arrays.fill(nine, 0);
			for(int j=0; j<9; j++) {
				if(nine[map[i][j]]>0) return false;
				nine[map[i][j]]++;
			}
		}
		return true;
	}
	private static boolean check_height() {
		for(int i=0; i<9; i++) {
			Arrays.fill(nine, 0);
			for(int j=0; j<9; j++) {
				if(nine[map[j][i]]>0) return false;
				nine[map[j][i]]++;
			}
		}
		return true;
	}
	
	
	private static boolean check_square() {
		
		for(int k=0; k<3; k++) {
			Arrays.fill(nine, 0);
			for(int i=0+k*3; i<3+k*3; i++) {
				for(int j=0; j<3; j++) {
					if(nine[map[j][i]]>0) return false;
					nine[map[j][i]]++;
				}
			}
		}
		
		for(int k=0; k<3; k++) {
			Arrays.fill(nine, 0);
			for(int i=0+k*3; i<3+k*3; i++) {
				for(int j=3; j<6; j++) {
					if(nine[map[j][i]]>0) return false;
					nine[map[j][i]]++;
				}
			}
		}
		
		for(int k=0; k<3; k++) {
			Arrays.fill(nine, 0);
			for(int i=0+k*3; i<3+k*3; i++) {
				for(int j=6; j<9; j++) {
					if(nine[map[j][i]]>0) return false;
					nine[map[j][i]]++;
				}
			}
		}
		
		
		
		return true;
	}

}
