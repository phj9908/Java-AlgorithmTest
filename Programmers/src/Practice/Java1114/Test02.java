package Practice.Java1114;

import java.util.Arrays;
import java.util.Scanner;

public class Test02 {
	
	public static int n,m;
	public static int[][] graph = new int[501][501]; // 1번 노드부터 500번 노드까지 생성하기 위함
			
	public static final int INF = (int)1e9;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		 n = sc.nextInt();
		 m = sc.nextInt();
		 
		 for(int i=0;i<501;i++) Arrays.fill(graph[i], INF);
		 
		 // 자기자신 -> 자기자신의 거리는 0으로 초기화
		 for(int i=0;i<n;i++) {
			 for(int j=0;j<n;j++) if(i==j) graph[i][j] = 0;
		 }
		 
		 // 각 간선에 대한 정보 입력받고 그 값으로 초기화
		 for(int i=0;i<m;i++) {
			 
			 // a에서 b로 가는 비용c
			 int a = sc.nextInt();
			 int b = sc.nextInt();
			 int c = sc.nextInt();
			 
			 graph[a][b] = c;
		 }
		 
		 // a와 b사이 걸쳐갈 지점 k
		 for(int k=1;k<=n;k++) {
			 for(int a =1;a<=n;a++) {
				 for(int b=1;b<= n;b++) {
					 graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
				 }
			 }
		 }
		 
		 for(int a = 1;a<=n;a++) {
			 for(int b = 1;b<=n;b++) {
				 
				 // 도달할 수 없으면 INF
				 if(graph[a][b] == INF) System.out.println("INF");
				 else System.out.println(graph[a][b] + " ");
			 }
			 System.out.println();
		 }
	}
	
	

}
