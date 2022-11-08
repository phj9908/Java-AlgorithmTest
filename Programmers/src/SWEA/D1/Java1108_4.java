package SWEA.D1;

import java.util.Arrays;
import java.util.Scanner;

//2063
public class Java1108_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr); // 오름차순 정렬
		
		System.out.print(arr[n/2]); 
	}

}
