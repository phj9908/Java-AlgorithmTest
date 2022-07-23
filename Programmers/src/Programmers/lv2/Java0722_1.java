// 커뮤러닝 - 게임맵 최단거리

package Programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Java0722_1 {
	
	public static boolean[][] visited;
	public int[][] d = {{-1,0},{1,0},{0,1},{0,-1}}; 
	public int y,x,n,m,answer;
	
	class Node{
		
		public Node(int y, int x, int distance) {
			this.y = y;
			this.x = x;
			this.distance = distance;
		}

		int x,y,distance;
		
	}
	
    public int solution(int[][] maps) {
    	
    	n = maps.length; m = maps[0].length;
    	y=0;x=0;
    	visited = new boolean[n][m];
    	
    	return bfs(maps,y,x);
    }

	public int bfs(int[][] maps,int y, int x) {
		
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(y,x,1)); // 현재 좌표,좌표까지의 거리
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			
			Node node = q.poll();
			if(node.y ==n-1 && node.x == m-1) return node.distance;
			
			for(int[] dir:d) {
				int ny = node.y + dir[0];
				int nx = node.x + dir[1];
				
				if(nx>=0&&ny>=0&&nx<n&&ny<m) {
					if(maps[ny][nx]==1 && !visited[ny][nx]) {
						visited[ny][nx] = true;
						q.offer(new Node(ny,nx,node.distance+1));
					}
				}
			}
			
		}
		return -1;
	}
 
}
