package Practice.Java1112;

import java.util.*;

// 부품찾기 - 방법1)이진탐색
public class Test09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		for(int i =0;i<n;i++) arr1[i] = sc.nextInt();
		
		Arrays.sort(arr1);
		
		int m = sc.nextInt();
		int[] arr2 = new int[m];
		for(int i=0;i<m;i++) arr2[i] = sc.nextInt();
		
		for(int i:arr2) {
			if(binarySearch(arr1,i,0,n-1)== -1) System.out.println("no");
			else
				System.out.println("yes");
		}

}

	private static int binarySearch(int[] arr, int target, int startIdx, int endIdx) {
		// TODO Auto-generated method stub
		while(startIdx<endIdx) {
			int mid =(startIdx + endIdx)/2;
			
			if(arr[mid] == target)
				return mid;
			else if(arr[mid]> target) endIdx = mid-1;
			else startIdx = mid+1;
		}
		return -1;
	}
