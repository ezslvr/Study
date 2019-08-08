import java.util.Scanner;

public class S1926 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt()+1;
		boolean flag = false;
		for(int i=1; i<n; i++) {
			int now = i;
			flag = false;
			while(now>0) {
				if((now%10)!=0 &&(now%10)%3==0) {
					System.out.print("-");
					flag = false;
				}
				else {
					if(now!=i) break;
					flag = true;
				}
				now = now/10;
			}
			if(flag) System.out.print(i+" ");
			else System.out.print(" ");
		}
	}

}
