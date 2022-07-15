// 플로이드 위셜

package ThisIsCodingTest;

import java.util.Arrays;
import java.util.Scanner;

public class Java0715_2 {
	
    // 노드의 개수(N), 간선의 개수(M)
    // 노드의 개수는 최대 500개라고 가정
	public static int n,m;
	public static int[][] graph = new int[501][501];
	
	public static final int INF = (int) 1e9;
	// 무한을 의미하는 10억
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		// 최단거리 테이블 모두 무한으로 초기화
		for(int i=0;i<501; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		// 자기 자신 -> 자기 자신 의 거리는 0으로 설정해주기
		for(int i=0; i<n;i++) {
			for(int j = 0;j<n;j++)
			{
				if(i==j) graph[i][j] = 0;
			}
		}
		
		// 각 간선에 대한 정보 입력받고 그값으로 초기화
		for(int i=0; i<m; i++) {
			
			// a에서 b로 가는 비용c
			int a= sc.nextInt();
			int b= sc.nextInt();
			int c = sc.nextInt();
			graph[a][b] = c;
		}
		
		// a와 b사이 걸쳐갈 지점 k
		for(int k=1;k<=n;k++) {
			for(int a = 1; a<=n;a++) {
				for(int b=1;a<=n;b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
				}
			}
		}
		
		for(int a =1;a<=n;a++) {
			for(int b = 1;b<=n; b++) {
				
                // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
                if (graph[a][b] == INF) {
                    System.out.print("INFINITY ");
                }
                // 도달할 수 있는 경우 거리를 출력
                else {
                    System.out.print(graph[a][b] + " ");
                }
			}
			System.out.println();
		}
	}
}
