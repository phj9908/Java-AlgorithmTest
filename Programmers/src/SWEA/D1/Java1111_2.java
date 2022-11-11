package SWEA.D1;

import java.util.Scanner;

//1989
public class Java1111_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int answer;
		
		for(int tc=1;tc<=T;tc++) {
			
			sc.nextLine();
			String str = sc.nextLine();
			answer=1;
			
			for(int i=0;i<str.length()/2;i++) {
				if(str.charAt(i)!=str.charAt(str.length()-1-i)) {
					answer=0;
					break;
				}
			}
			
			System.out.println("#"+tc+" "+answer);
		}
	}

}
