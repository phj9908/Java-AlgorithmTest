package Practice.Java1113;

import java.util.Arrays;
import java.util.Scanner;

// dp - 효율적인 화폐구성
public class Test05 {

	public static int[] d,p;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 화폐단위 개수
		int m = sc.nextInt(); // 만들어야 하는 최종 수
		
		d= new int[m+1]; 
		p = new int[n]; // 화폐단위 배열
		
		for(int i=0;i<n;i++) p[i] = sc.nextInt();
		
		Arrays.fill(d, 10001); // 미리 10001로 값 초기화
		d[0] = 0;
		
		for(int i:p) {
			for(int j=i;j<m;j++) {
				if(d[j-i]!=10001) 
					d[j] = Math.min(d[j], d[j-i]+1);
					// d[2] =1, d[4] =2....
					// d[3] =1.d[6] = 2...
					// d[5] = 2,d[7] = 3...
			}
		}
		
		if(d[m] == 10001) { // 최종적으로 m원을 만드는 방법이없을 때
			System.out.println(-1);
		}else
			System.out.println(d[m]);
		
	}

}
