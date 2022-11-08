package SWEA.D1;

import java.util.Scanner;

// 2050
public class Java1108_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		String str= sc.nextLine();
		
		for(int i=0;i<str.length();i++) {
			System.out.print(str.charAt(i)-'A'+1+" ");
		}
	}

}
