// 미래 도시
package ThisIsCodingTest;

import java.util.*;

public class Java0715_4 {
	
	public static int n,m,x,k;
	public static int[][] graph=new int[101][101];
	public static final int INF = (int) 1e9;
	
	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=0;i<101;i++) Arrays.fill(graph[i], INF);
		
		for(int i=1;i<=n;i++) {
			for(int j=1; j<=n;j++) {
				if(i==j) graph[i][j] =0;
			}
		}
		
		
		for(int i=0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			graph[a][b] = 1;
			graph[b][a] = 1; // 주의) 양방향 노드이기에!
		}
		
		x = sc.nextInt();
		k = sc.nextInt();
		
		for(int k=1;k<=n;k++) {
			for(int a =1;a<=n;a++) {
				for(int b =1;b<=n;b++) {
					graph[a][b] = Math.min(graph[a][b],graph[a][k]+graph[k][b]);
				}
			}				
		}
			
		int answer = graph[1][k] + graph[k][x];
		if(answer >= INF) System.out.print(-1);
		else System.out.print(answer);
		
		
	}
}
