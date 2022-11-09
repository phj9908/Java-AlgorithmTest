package SWEA.D1;

import java.util.Scanner;

//1986
public class Java1109_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int answer=0;
		
		for(int tc=1;tc<=T;tc++) {
			
			answer=0;
			int n = sc.nextInt();
			for(int i=1;i<=n;i++) {
				if(i%2==1)
					answer+=i;
				else
					answer-=i;
			}
			System.out.printf("#%d %d\n",tc,answer);
			
		}
	}

}
