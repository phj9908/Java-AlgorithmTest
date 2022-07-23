// 럭티 스트레이트

package ThisIsCodingTest;

import java.util.*;

public class Java0723_2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		char[] n = sc.next().toCharArray();
		
		int left=0,right=0;
		for(int i=0;i<n.length;i++) {
			if(i<n.length/2)
				left += n[i]-'0';
			else
				right+=n[i]-'0';
			
		}
		
		if(left == right) System.out.print("LUCKY");
		else System.out.print("READY");
	}
}
