// 개미 전사

package ThisIsCodingTest;

import java.util.Scanner;

public class Java0714_9 {
	
	public static int[] d;
	public static int[] p;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		d = new int[n+1];
		p = new int[n+1];
		for(int i=1;i<=n;i++) p[i] = sc.nextInt();
		
		d[1] = p[1];
		d[2] = d[0] + p[2];
		for(int i=3;i<=n;i++) d[i] = Math.max(d[i-2]+p[i], d[i-3]+p[i]);
		
		System.out.print(d[n]);
	}
}
