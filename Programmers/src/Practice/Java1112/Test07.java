package Practice.Java1112;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Test07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		Integer[] arrA = new Integer[n];
		Integer[] arrB = new Integer[n];
		// Collections.reverseOrder()를 쓰기위해 int[]말고 Integer[]
		
		// 배열 입력받기
		for(int i=0;i<n;i++) arrA[i] = sc.nextInt();
		for(int i=0;i<n;i++) arrB[i] = sc.nextInt();
		
		Arrays.sort(arrA);
		Arrays.sort(arrB,Collections.reverseOrder());
		
		for(int i=0;i<n;i++) {
			if(k>0 && arrA[i]<arrB[i]) {
				
				int temp = arrA[i];
				arrA[i] = arrB[i];
				arrB[i] = arrA[i];
				
				k--;
			}
			else break;
		}
		
		int sum=0;
		for(int i:arrA) sum+=i;
		
		System.out.println(sum);
	}

}
