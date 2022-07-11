// 왕실의 나이트

package ThisIsCodingTest;

import java.util.Scanner;


public class Java_0711_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String inputData = scanner.nextLine();
		int col = (inputData.charAt(0) - 'a') + 1; 
		int row = inputData.charAt(1) - '0';
		// 좌표번호가 (1,1)부터 시작
		
		int[][] d = {{-2,1},{-2,-1},{2,1},{2,-1},{1,-2},{1,2},{-1,-2},{-1,2}};
		
		int answer=0;
		for(int[] dir:d) {
			int ny=row+dir[0];
			int nx=col+dir[1];
			
			if(ny<1||ny>8||nx<1||nx>8) continue;
			
			answer++;
			
		}
		
		System.out.print(answer);
	}
}
