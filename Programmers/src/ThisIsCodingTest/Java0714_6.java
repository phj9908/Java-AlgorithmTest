// 떡볶이 떡 만들기

package ThisIsCodingTest;

import java.util.*;

public class Java0714_6 {
	public static void main(String[] args) {
		
		int answer = 0;
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0;i<n;i++) arr[i] = sc.nextInt();
		
		int start = 0;
		
		Arrays.sort(arr);
		int end = arr[n-1];
		
		while (start<=end) {
			int mid = (start+end)/2;
			
			long sum=0; // 떡의 개수 n과 떡의 길이 m의 범위가 엄청 크기에
			for(int i:arr) {
				sum+= (i>mid)? i-mid:0;
			}
			
			if(sum>=m) { 
				start = mid+1;
				answer = mid;
			}
			else if(sum<m) end = mid-1;
		}
		
		System.out.print(answer);
	}
}
