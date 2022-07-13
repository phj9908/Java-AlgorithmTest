// 미로탈출
package ThisIsCodingTest;

import java.util.*;

// 큐에 좌표를 쉽게 저장하고, 접근하기 위해 클래스 생성!
class Node{
	
	private int y;
	private int x;
	
	public Node(int y,int x) {
		this.y= y;
		this.x= x;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}


public class Java0713_3 {
	
	public static int n,m;
	public static int[][] arr;
	public static int[][] d= {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<n;i++) {
			String str = sc.nextLine();
			for(int j=0;j<m;j++) {
				arr[i][j]=str.charAt(j) - '0';
			}
		}
		
		System.out.print(bfs(0,0));
		
	}

	public static int bfs(int y, int x) {
		
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(y,x));
		
		while(!q.isEmpty()) {
			
			Node node = q.poll();
			y = node.getY();
			x = node.getX();
			
			// 현재 위치에서 상하좌우 좌표 확인
			for(int[] dir:d) {
				
				int ny = y+ dir[0];
				int nx = x+dir[1];
				
				if(ny<0||ny>=n||nx<0||nx>=m) continue;
				if(arr[ny][nx] == 0) continue;
				
				// 해당좌표를 처음 방문하는 경우에만 
				if(arr[ny][nx]==1) {
					arr[ny][nx] = arr[y][x]+1;
					// 현재좌표에 이전좌표까지의 최단거리+1 저장
					
					q.offer(new Node(ny,nx));
				}
			}
		}
		
		// 가장 오른쪽 아래까지의 최단거리 반환
		return arr[n-1][m-1];
		
	}
}
