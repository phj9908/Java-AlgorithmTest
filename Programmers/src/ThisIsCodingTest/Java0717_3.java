// 곱하기 혹은 더하기
package ThisIsCodingTest;

import java.util.Scanner;

public class Java0717_3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char[] charArr= sc.nextLine().toCharArray();
		
		int sum=0;
		for(int i=0;i<charArr.length;i++) {
			
			int a = charArr[i] -'0';

			if(a>1&&sum>1) sum*=a;
			else sum+=a;
		}
		System.out.print(sum);
		
	}
}
