package SWEA.D1;

import java.util.Scanner;

//1979
public class Java1112_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[][] arr = new int[n][n];
			int answer=0;
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int c_cnt=0,r_cnt=0;
			for(int i=0;i<n;i++) {
				c_cnt=0;
				
				for(int j=0;j<n;j++) {
					if(arr[i][j]==0) {
						if(c_cnt==k) 
							answer++;
						c_cnt=0;
					}
					else {
						c_cnt++;
					}
				}
				if(c_cnt==k)
					answer++;
				
			}
			
			for(int i=0;i<n;i++) {
				r_cnt=0;
				
				for(int j=0;j<n;j++) {
					if(arr[j][i]==0) {
						if(r_cnt==k) 
							answer++;
						r_cnt=0;
					}
					else {
						r_cnt++;
					}
				}
				if(r_cnt==k)
					answer++;
				
			}
			
			System.out.println("#" + tc + " "+ answer);
		}
	}

}
