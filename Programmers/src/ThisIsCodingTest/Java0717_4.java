// 문자열 뒤집기

package ThisIsCodingTest;

import java.util.Scanner;

public class Java0717_4 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
	
		int cnt0=0; // 모두 0으로 바꿀때
		int cnt1=0; // 모두 1로 바꿀 때
		
		if(str.charAt(0)=='0') cnt1++;
		else cnt0++;
		
		for(int i=0;i<str.length()-1;i++) {
			if(str.charAt(i)!=str.charAt(i+1)) {
				if(str.charAt(i+1) == '0') cnt1++;
				else cnt1++;
			}
		}
		
		System.out.print(Math.min(cnt0, cnt1));
	}
}
