// 만들 수 없는 금액
// 1씩 증가시켜 그 값을 특정 동전의 조합들로 만들수 있는지 도출하는 로직은 어렵다
// 예를 들어 1 1 2 3 9 으로 8원을 만들려 하면 
// 1,1,2,3 원을 모두 합쳐 만들 수 있는 금액이 최대 7원이기에 불가능
// 따라서 만들수 없는 금액 최소값은 8원

package ThisIsCodingTest;

import java.util.Arrays;
import java.util.Scanner;

public class Java0717_5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt(); 
		}
		
		Arrays.sort(arr);  
		
		int target=1;
		for(int i=0;i<n;i++) {
			
			if(target < arr[i]) break;
			target +=arr[i];
			
		}
		
		System.out.print(target);
		
	}
}
