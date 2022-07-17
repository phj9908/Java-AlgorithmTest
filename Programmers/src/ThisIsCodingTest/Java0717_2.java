// 모험가 길드

package ThisIsCodingTest;

import java.util.*;

public class Java0717_2 {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> arr = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			arr.add(sc.nextInt()); 
		}
		
		Collections.sort(arr);
		int answer =0;
		
		int sum=0;
		for(int i:arr) {
			sum++;
			if(sum>=i) {
				answer++;
				sum=0;
			}
		}
		System.out.print(answer);
		
	}
}
