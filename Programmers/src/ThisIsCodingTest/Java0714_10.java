// 바닥 공사
// 점화식 dp[n]= 2*dp[n-2]+dp[n-1] (n개에서 타일을 채울수있는 방법의 수)
// n-2는 누워있는 타일2개 / n-1은 세워진 타일 하나를 뜻함
// 모든 경우의 수를 구하는 것이기에 2*1 ,2*2 타입으로 구성하는 경우 + 1*2 타입으로 구성하는 경우의 수 더해주기

package ThisIsCodingTest;

import java.util.Scanner;

public class Java0714_10 {
	
	public static int[] d;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		d = new int[n+1];
		
		d[1] = 1;
		d[2] = 3;
		for(int i=3;i<=n;i++) d[i] = (2*d[i-2]+d[i-1])%796796;
		
		System.out.print(d[n]);
	}
}
