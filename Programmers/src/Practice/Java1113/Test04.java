package Practice.Java1113;

import java.util.Scanner;

// dp 바닥공사
public class Test04 {
	
	public static int[] d;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d= new int[n+1];
		
		d[1] = 1;
		d[2] = 3;
		for(int i=3;i<=n;i++) d[i] = (2*d[i-2] +d[i-1])%796796;
		
		System.out.println(d[n]);
	}

}
