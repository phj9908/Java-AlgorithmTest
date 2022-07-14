// 위에서 아래로 

package ThisIsCodingTest;

import java.util.*;

public class Java0714_2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Integer[] arr = new Integer[n];
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr,Collections.reverseOrder());
		// 내림차순 정렬
		
		for(int i:arr) System.out.print(arr[i]+ " ");		
	}
	

}
