package Practice.Java1112;

import java.util.Arrays;
import java.util.Scanner;

// 떡볶이 떡 만들기 - 이진탐색
public class Test12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int answer=0;
		int[] arr = new int[n];
		for(int i=0;i<n;i++) arr[i] = sc.nextInt();
		
		int start =0;
		
		Arrays.sort(arr); // 오름차순 정렬
		int end = arr[n-1]; // 가장 긴 떡
		
		while(start<=end) {
			int mid = (start+end)/2;
			
			long sum=0; // n,m범위가 너무 커서
			for(int i:arr)
				sum+= (i>mid)? i-mid:0;
			
			if(sum>=m) {
				start = mid+1;
				answer = mid;
			}
			else if(sum<m) end = mid-1;
			
		}
		System.out.println(answer);
	}

}
