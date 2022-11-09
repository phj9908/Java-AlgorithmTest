package Practice.Java1109;

import java.util.Scanner;

// 음료수 얼려먹기
public class Test04 {

	public static int n,m;
	public static int[][] arr;
	public static int[][] dir= {{-1,0},{1,0},{0,1},{0,-1}};
	
	public static boolean dfs(int x,int y) {
		
		if(x<0||y<0||x>=m||y>=n)
			return false;
		
		if(arr[y][x] ==0) {
			
			arr[y][x] =1;
			
			for(int[] d:dir)
				dfs(y+d[0],x+d[1]);
			
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<n;i++) {
			String str = sc.nextLine();
			for(int j=0;j<m;j++) {
				arr[i][j] = str.charAt(j) -'0';
			}
		}
		
		int answer =0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(dfs(i,j)) answer++;
			}
		}
		
		System.out.println(answer);
	}

}
