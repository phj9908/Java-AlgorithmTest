// 게임 개발

package ThisIsCodingTest;

import java.util.Scanner;

public class Java0711_2 {
	
	// 이런 문제를 풀때 캐릭터의 방향 전환 등 메소드를 따로 분리해서 작성하는 경우가 많기 때문에
	// 메소드들이 공유할 수 있는 map[ ][ ]이나 visit[ ][ ] 등은 static 변수로 선언하여 관리하기 용이하도록 함
	static int n,m,y,x,dir;
	static int[][] visited;
	static int[][] arr;
	static int[][] d = {{-1,0},{0,1},{1,0},{0,-1}}; // 복동남서
	
	public static void turn_left() {
		dir--;
		if(dir==-1) dir=3;
	}
	
	public static void main(String[] args) {
		
		Scanner scanner =new Scanner(System.in);
		
		n=scanner.nextInt();
		m=scanner.nextInt();
		
		arr=new int[n][m];
		visited=new int[n][m];
		
		y=scanner.nextInt();
		x=scanner.nextInt();
		dir=scanner.nextInt();
		
		visited[y][x]= 1; // 현재 위치 방문 처리
		
		// 전체 맵 정보 입력받기
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) arr[i][j]=scanner.nextInt(); 
		}
		
		int cnt=1; 		// 이동한 칸 갯수
		int turn=0;		// 방향 바꾼 횟수
		
		while (true) {
			
			turn_left();
			int ny = y+d[dir][0];
			int nx = x+d[dir][1];
			
			// 방문한 적 없는 육지이면 이동
			if(arr[ny][nx] ==0&&visited[ny][nx]==0) {

				visited[ny][nx] =1;
				y=ny;
				x=nx;
				cnt++;
				turn=0;
				
				continue;
			}
			else turn++; // 회전했는데 가본 칸이나 바다일 때
			
			if(turn==4) {
				
				// 뒤로 가보고
				ny= y - d[dir][0];
				nx = x - d[dir][1];
				
				// 뒤가 육지면 뒤로 이동
				if(arr[ny][nx] == 0) {
					y = ny;
					x= nx;
				}
				else break;
				turn=0;
			}
			
		}
		System.out.print(cnt);
	}

}
