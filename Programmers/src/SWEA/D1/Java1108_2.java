package SWEA.D1;

import java.util.Scanner;

//2058 자릿수 더하기
public class Java1108_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		int[] arr = new int[4];
		int result=0;
		
		
		for(int i=0;i<n.length();i++) {
			
			int num = n.charAt(i) -'0';
			result +=num;
		}
		
		System.out.print(result);
	}

}
