package Practice.Java1112;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 내림차순 정렬
//내림차순 정렬시 Collections.reverseOrder() 메서드가 필요한데, 
// 이때 int[] 배열이 아닌 Integer[] 배열이 요구된다.
public class Test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Integer[] arr = new Integer[n];
		for(int i=0; i<arr.length;i++)
			arr[i] = sc.nextInt();
		
		// 내림차순 정렬
		Arrays.sort(arr,Collections.reverseOrder());
		
		for(int i:arr) System.out.println(arr[i]+" ");
	}

}
