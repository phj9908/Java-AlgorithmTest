package SWEA.D1;

import java.util.Base64;
import java.util.Scanner;

//1923
public class Java1109_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int tc=1;tc<=T;tc++) {
			String encode = sc.nextLine();
			String decode = new String(Base64.getDecoder().decode(encode));
			
			System.out.printf("#%d %s\n",tc,decode);
		}
	}

}
