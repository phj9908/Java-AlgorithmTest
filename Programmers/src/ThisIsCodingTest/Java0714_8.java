// 1로 만들기

package ThisIsCodingTest;

import java.util.*;

public class Java0714_8 {
	
	public static int[] d;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		d = new int[n+1];
		
		for(int i=2;i<=n;i++) {
			
			d[i] = d[i-1]+1; 
			
			if(d[i]%5==0) d[i] = Math.min(d[i], d[i/5]+1); 
			if(d[i]%3 ==0) d[i] = Math.min(d[i],d[i/3]+1);
			if(d[i]%2 ==0) d[i] = Math.min(d[i], d[i/2]+1);
			
		}
		
		System.out.print(d[n]);
	}
}
