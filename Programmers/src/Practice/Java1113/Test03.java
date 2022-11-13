package Practice.Java1113;

import java.util.Scanner;

// dp
public class Test03 {

	public static int[] d,p;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		d= new int[n+1];
		p=new int[n+1];
		
		for(int i=1;i<=n;i++) p[i] = sc.nextInt();
		
		d[1] = p[1];
		d[2] = d[0] + p[2];
		for(int i=3;i<=n;i++) d[i] = Math.min(d[i-2]+p[i], d[i-3]+p[i]);
		
		System.out.println(d[n]);
	}

}
