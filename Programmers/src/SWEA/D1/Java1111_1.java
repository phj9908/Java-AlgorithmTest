package SWEA.D1;

import java.util.Scanner;

//1284
public class Java1111_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int answer;
		for(int tc=1;tc<=T;tc++) {
			
			answer=0;
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();
			
			int A = W*P;
			int B =Q;
			
			if(W>R)
				B += S*(W-R);
			answer = Math.min(A, B);
			
			
			System.out.println("#"+tc+" "+answer);
		}
	}

}
