// 상하좌우
//	입력 예시
//	5
//	R R R U D D
//	
//	출력 예시
//	3 4
package ThisIsCodingTest;

import java.util.*;

public class Java0709_4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		sc.nextLine();   // nextInt()의 개행문자 제거용
		
		String[] arr=sc.nextLine().split(" "); 
		// 입력 한 줄을 한 번에 받아 배얄에 할당
		// char 여러개 한 번에 입력받기
		
		int x=1,y=1;
		int[][] d = {{-1,0},{1,0},{0,-1},{0,1}}; // 상하좌우
		char[] type = {'U','D','L','R'};
		
		for(String s:arr) {
			char word =s.charAt(0);
			int ny=0,nx=0;
			
			// if문 4개 대신 for문을 이용
			for(int w=0;w<4;w++) { 
				if(word == type[w]) {
					ny=y+d[w][0];
					nx=x=d[w][1];
				}
			}
			
			// 공간을 이탈하면
			if(ny<0||ny>=n||nx<0||nx>=n) 
				continue;
	
			x =nx;
			y =ny;
			
		}
		System.out.print(x+" "+y);
	}
}
