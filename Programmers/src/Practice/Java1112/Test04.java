package Practice.Java1112;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// bfs 미로탈출

// 입력
//5 6
//101010
//111111
//000001
//111111
//111111

class Node{
	
	private int y,x;

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public Node(int y, int x) {
		//super();
		this.y = y;
		this.x = x;
	}
	
}

public class Test04 {

	public static int n,m;
	public static int[][] arr;
	public static int[][] d = {{-1,0},{1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<n;i++) {
			String str = sc.nextLine();
			for(int j=0;j<m;j++)
				arr[i][j] = str.charAt(j) -'0';
		}
		
		System.out.println(bfs(0,0));
	}

	private static int bfs(int y, int x) {
		// TODO Auto-generated method stub
		
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(y,x));
		
		while(!q.isEmpty()) {
			
			Node node = q.poll();
			y = node.getY();
			x = node.getX();
			
			for(int[] dir:d) {
				
				int ny = y + dir[0];
				int nx = x + dir[1];
				
				// 범위를 벗어나거나 이미 방문했으면 패스
				if(ny<0||ny>=n-1||nx<0||nx>=m-1) continue;
				if(arr[ny][nx] == 0) continue;
				
				if(arr[ny][nx] == 1) {
					
					// 현재좌표에 인전좌표까지의 최단거리+1저장
					arr[ny][nx] = arr[y][x]+1;
					
					q.offer(new Node(ny,nx));
				}
				
			}
		}
		
		
		return arr[n-1][m-1];
	}

}
