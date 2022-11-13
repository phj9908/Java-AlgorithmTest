package SWEA.D1;

import java.util.Scanner;

// 1948
public class Java1948 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] arr = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		
		for(int tc =1;tc<=T;tc++) {
			
			int m1 = sc.nextInt();
			int d1 = sc.nextInt();
			int m2 = sc.nextInt();
			int d2 = sc.nextInt();
			int answer=0;
			
			if(m1 == m2) answer = d2-d1+1;
			else {
				answer = (arr[m1]-d1+1)+d2;
				for(int i=m1+1;i<m2;i++) {
					answer+=arr[i];
				}
			}
			
			System.out.println("#" + tc + " "+ answer);
		}
	}

}
