package Practice.Java1112;

import java.util.Scanner;

// 재귀로 구현한 이진탐샋
public class Test08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int target = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0;i<n;i++) arr[i] = sc.nextInt();
		
		int answer = binarySearch(arr,target,0,n-1);
		if(answer ==-1)
			System.out.println("NOne");
		else
			System.out.println(answer+1);
		
	}

	private static int binarySearch(int[] arr, int target, int startIdx, int endIdx) {
		// TODO Auto-generated method stub
		if(startIdx>endIdx) return-1;
		int mid = (startIdx+endIdx)/2;
		
		if(arr[mid]<target)
			binarySearch(arr,target,mid+1,endIdx);
		if(target == arr[mid]) return mid;
		else
			binarySearch(arr,target,startIdx,mid-1);
		
		return -1;
	}

}
