package SWEA.D1;

import java.util.Scanner;

//1959
public class Java1113_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int answer;
		
		for(int tc=1;tc<=T;tc++) {
			answer=0;
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] arr1 = new int[n];
			int[] arr2 = new int[m];
			
			for(int i=0;i<n;i++) arr1[i] = sc.nextInt();
			for(int i=0;i<m;i++) arr2[i] = sc.nextInt();
			
			if(n<m) {
				for(int i=0;i<m-n+1;i++) {
					int total=0;
					for(int j=0;j<n;j++) {
						total += arr1[j]*arr2[j+i];
					}
					answer = Math.max(total, answer);
				}
			}
			else {
				for(int i=0;i<n-m+1;i++) {
					int total=0;
					for(int j=0;j<m;j++) {
						total += arr1[j+i]*arr2[j];
					}
					answer = Math.max(total, answer);
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}  

}
