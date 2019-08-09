import java.util.Arrays;
import java.util.Scanner;

public class S1983 {
	static class score implements Comparable<score>{
		int idx;
		int mid;
		int fin;
		int assign;
		public score(int mid, int fin, int assign,int idx) {
			super();
			this.mid = mid;
			this.fin = fin;
			this.assign = assign;
			this.idx = idx;
		}

		@Override
		public String toString() {
			return "score [idx=" + idx + ", mid=" + mid + ", fin=" + fin + ", assign=" + assign + "]";
		}

		@Override
		public int compareTo(score o) {
			return (int) (((o.mid*0.35+o.fin*0.45+o.assign*0.2) - (this.mid*0.35+this.fin*0.45+this.assign*0.2))*1000);
		}
		
	}
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			n = sc.nextInt();
			int k = sc.nextInt()-1;
			score[] arr = new score[n];
			for(int i=0; i<n; i++) {
				arr[i] = new score(sc.nextInt(), sc.nextInt(), sc.nextInt(),i);
			}
			
			Arrays.sort(arr);
			
			System.out.print("#"+t+" ");
			for(int i=0; i<n; i++) {
				if(arr[i].idx == k) {
					i++;
					check(i);
					break;
				}
			}
			
			//32.9 + 43.2+ 20 = 96.1;
			//33.95 + 44.1 + 18 = 96.05;
		}
	}
	private static void check(int i) {
		int temp = n/10;
		if(i<=temp) {
			System.out.println("A+");
		}
		else if(temp<i && i<=temp+temp) {
			System.out.println("A0");			
		}
		else if(temp+temp<i && i<=3*temp) {
			System.out.println("A-");			
		}
		else if(3*temp<i && i<=4*temp) {
			System.out.println("B+");			
		}
		else if(4*temp<i && i<=5*temp) {
			System.out.println("B0");			
		}
		else if(5*temp<i && i<=6*temp) {
			System.out.println("B-");			
		}
		else if(6*temp<i && i<=7*temp) {
			System.out.println("C+");			
		}
		else if(7*temp<i && i<=8*temp) {
			System.out.println("C0");			
		}
		else if(8*temp<i && i<=9*temp) {
			System.out.println("C-");			
		}
		else if(9*temp<i && i<=10*temp) {
			System.out.println("D0");			
		}
	}

}
