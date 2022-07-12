// 음료수 얼려먹기

package ThisIsCodingTest;

import java.util.Scanner;

public class Java0712_3 {
	
	public static int n;
	public static int m;
	
	public static int[][] d= {{-1,0},{1,0},{0,1},{0,-1}};
	public static int[][] arr;
	
	public static boolean dfs(int x,int y) {
		
		if(x<0||x>m||y<0||y>n) return false;
		// 범위를 벗어나면 탈출
		
		if(arr[y][x] ==0 ) { // 현재노드에 방문을 아직 안했다면
		
			arr[y][x] = 1;
			
			// 해당 노선의 상하좌우 좌표의 방문처리
			for (int[] dir : d)
				dfs(y + dir[0],x+ dir[1]);

			return true;	
		}
		
		return false;

		}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n= sc.nextInt();
		m=sc.nextInt();
		sc.nextLine();
		
		
		// 2차원 리스트의 맵 입력받기
		for(int i=0;i<n;i++) {
			String str = sc.nextLine();		// 한 줄씩 읽어들여
			for(int j=0;j<m; j++) {
				arr[i][j] = str.charAt(j) - '0'; // 문자하나씩 int로 변환하여 할당
			}
		}
		
		int answer =0;
		for(int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				if(dfs(i,j)) answer++;
			}
		}
		
		System.out.println(answer);
	}
}
