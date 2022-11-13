package Practice.Java1113;

import java.util.Scanner;

// DP
public class Test02 {

	public static int[] d;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d = new int[n+1]; // 자바는 배열 초기화시 디폴트 원소값으로 0을 가짐
//		d[0] = 0;
//		d[1] = 0;
		
		for(int i=2;i<=n;i++) {
			
			d[i] = d[i-1]+1;
			
			if(d[i]%5 == 0) d[i] = Math.min(d[i], d[i/5]+1);
			if(d[i]%3 == 0) d[i] = Math.min(d[i], d[i/3]+1 );
			if(d[i]%2 == 0) d[i] = Math.min(d[i], d[i/2]+1);
		}
		
		System.out.println(d[n]);
	}

}
