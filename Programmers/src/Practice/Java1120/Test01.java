package Practice.Java1120;

import java.util.Scanner;
//로봇모으기
public class Test01 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		
		for(int tc = 1;tc<=T;tc++) {
			
			int m= sc.nextInt();
			int n = sc.nextInt();
	
			int[] robots = new int[n];
			int answer = 0;
			int maxR=0;
			
			for(int i=0;i<n;i++) {
				
				int x = sc.nextInt()-1;
				int y = sc.nextInt()-1;
				
				robots[i] = x;
				maxR = Math.max(maxR, y); 
			}
			
			answer+=maxR; // 모두 0열로 set
			
			int minCnt=1000000;
			int maxX=0,minX = m-1;
			
			for(int x:robots) { // 가장 큰 x,가장 작은 x
				
				maxX = Math.max(maxR, x); 
				minX = Math.min(minX, x);
				
			}
			
			minCnt = Math.min(maxX, (m-1)-minX);
			
			answer+=minCnt;
			System.out.println("#" + tc +" "+ answer);
			
		}
		
		
	}

}
