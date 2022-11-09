package Practice.Java1109;

import java.util.Scanner;

// 게임개발
public class Test01 {
	
	static int n,m,y,x,dir;
	static int[][] visited;
	static int[][] arr;
	static int[][] d = {{-1,0},{1,0},{0,1},{0,1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n][m];
		visited = new int[n][m];
		
		y = sc.nextInt();
		x = sc.nextInt();
		dir = sc.nextInt();
		
		visited[y][x] = 1;
		
		for(int i=0;i<n;i++) {
			for(int j=0;i<m;j++)
				arr[i][j] = sc.nextInt();
		}
		
		int cnt=1,turn=0;
		
		while(true) {
			
			turn_left();
			
			int ny=y+d[dir][0];
			int nx = x+d[dir][1];
			
			// 육지이고 방문한적 x 이면
			if(arr[ny][nx] == 0&&visited[ny][nx]==0) {
				
				visited[ny][nx] = 1;
				
				y=ny;
				x = nx;
				cnt++;
				turn=0;
				
				continue;
				
			}
			else turn++;
			
			if(turn==4) {
				
				//뒤로 가보고
				ny = y - d[dir][0];
				nx = x - d[dir][1];
				
				// 육지면
				if(arr[ny][nx] ==0) {
					y = ny;
					x = nx;
				}else break;
				
				turn=0;
			}
		}
		System.out.print(cnt);
	}

	private static void turn_left() {
		// TODO Auto-generated method stub
		dir--;
		if(dir<0) dir=3;
	}	
}
