// 볼링공 고르기

package ThisIsCodingTest;

import java.util.Scanner;

public class Java0717_6 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		int m= sc.nextInt();
		
		int[] arr = new int[11]; // 1~10 무게별 공 갯수 
		for(int i=1;i<=10;i++) {
			int x = sc.nextInt();
			arr[x]++;
		}
		
		int answer =0;
		for(int i=1;i<=m;i++) {
			
			n -= arr[i]; // 무게 i의 공 갯수 빼기
			answer+= n*arr[i];
		}
		
		System.out.print(answer);
		
	}
}
