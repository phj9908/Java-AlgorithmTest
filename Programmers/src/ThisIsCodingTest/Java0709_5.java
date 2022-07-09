// 시각
package ThisIsCodingTest;

import java.util.*;

public class Java0709_5 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int n=sc.nextInt();
		int answer =0;
		
		int total=((n+1)*3600)-1; // n시 59분 59초를 모두 초로 바꿈
		int[] time=new int[3];
		
		while(total>=0) {
			
			time[0]= total/3600;
			time[1]=(total%3600)/60;
			time[2]=(total%3600%60);
			
			
			for(int i:time) {
				
				// 방법1) 문자열에 3 있는지 확인
				String str=String.valueOf(i);
				if(str.contains("3")) answer++;
				
//				// 방법2) 연산 이용
//				if(i/10==3||i%10==3) answer++;
			}
			
			total--;
		}
		
		System.out.print(answer);
	}
}
