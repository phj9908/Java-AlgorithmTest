package SWEA.D1;

import java.util.Scanner;

//1945
public class Java1109_1 {

	public static int[] num = {2,3,5,7,11};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int ans =0;
		
		for(int i=1;i<=T;i++) {
			int n = sc.nextInt();
			int[] arr = {0,0,0,0,0};
			
			for(int j=0;j<num.length;j++) {
				
				ans=0;
				while(n%num[j]==0) {
					n/=num[j];
					ans++;
				}
				arr[j] = ans;
			}
			
			System.out.format("#%d %d %d %d %d %d\n",i,arr[0],arr[1],arr[2],arr[3],arr[4]);
		}
	}

}
