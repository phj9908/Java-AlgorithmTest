// 1로 만들기

package ThisIsCodingTest;
import java.util.*;

public class Java0709_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		int k= sc.nextInt();
		int answer =0;
		
		while(n>1) {
			if(n%k==0)
				n/=k;
			else 
				n--;
			
			answer++;
		}
		System.out.print(answer);
	}
}
