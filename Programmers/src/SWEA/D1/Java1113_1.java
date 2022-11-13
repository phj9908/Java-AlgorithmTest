package SWEA.D1;

import java.util.Scanner;

//2007
public class Java1113_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		int answer;
		
		for(int tc=1;tc<=T;tc++) {
			answer=0;
			
			String str = sc.next();
			for(int i=1;i<str.length();i++) {
				String a = str.substring(0,i);
				String b = str.substring(i,i+i);
				if(a.equals(b)) {
					answer=i;
					break;
				}
				
			}
			
			System.out.println("#" + tc+ " "+ answer);
		}
	}

}
