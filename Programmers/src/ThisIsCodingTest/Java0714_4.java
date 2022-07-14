// 재귀로 구현한 이진탐색

package ThisIsCodingTest;

import java.util.Scanner;

public class Java0714_4 {
	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		int n = sc.nextInt();
		int target = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int answer = binarySearch(arr,target,0,n-1);
		if(answer ==-1 )
			System.out.print("None");
		else
			System.out.print(answer+1);
	}

	public static int binarySearch(int[] arr, int target, int startIdx, int endIdx) {
		
		if(startIdx>endIdx) return -1;
		int mid = (startIdx+endIdx)/2;
		
		if(target>arr[mid])
			binarySearch(arr, target, mid+1, endIdx);
		if(target == arr[mid]) return mid;
		else
			binarySearch(arr, target, startIdx, mid-1);
		
		return -1;
	}
}
