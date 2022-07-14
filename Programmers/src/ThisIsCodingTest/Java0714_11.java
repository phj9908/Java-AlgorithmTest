// 효율적인 화폐 구성(다시풀어보기)
package ThisIsCodingTest;

import java.util.Arrays;
import java.util.Scanner;

public class Java0714_11 {
	
	public static int[] d;
	public static int[] p;
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int n =sc.nextInt();
		int m = sc.nextInt();
		
		d = new int[m+1];
		p= new int[n]; // 화폐단위 배열
		
		for(int i=0;i<n;i++) {
			p[i] = sc.nextInt();
		}
		
		Arrays.fill(d, 10001); // 미리 초기화
		d[0] = 0;
		
		for(int i:p) { 
			for(int j=i;j<=m;j++) { 
				if(d[j-i]!=10001) d[j] = Math.min(d[j], d[j-i]+1);
				// d[2]=1,d[4]= 2,...
				// d[3] =1; d[6] =2 ...
				// d[5] = 2, d[7] = 3 ...
			}
			
		}
		
        
        if (d[m] == 10001) { // 최종적으로 M원을 만드는 방법이 없는 경우
            System.out.println(-1);
        }
        else {
            System.out.println(d[m]);
        }
	}
}
