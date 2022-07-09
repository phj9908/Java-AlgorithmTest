// 숫자 카드 게임
//	입력
//	3 3
//	3 1 2
//	4 1 4
//	2 2 2 

package ThisIsCodingTest;
import java.util.*;

public class Java0709_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int answer =0;
		
		for (int i=0; i<n;i++) {
			int min = 10001;
			
			for(int j=0;j<m;j++) {
				int x = sc.nextInt();
				min = Math.min(min,x);
			} // 각 row내 가장 작은 값 도출
			
			answer = Math.max(answer, min);	
		}
		System.out.println(answer);
	}
}
