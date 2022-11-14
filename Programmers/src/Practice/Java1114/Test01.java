package Practice.Java1114;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// 다익스트라 최단경로

// 각 노드의 번호, 비용에 쉽게 접근하기 위해 class 생성
class Node implements Comparable<Node>{
	
	private int idx,distance;

	public Node(int idx, int distance) {
		//super();
		this.idx = idx;
		this.distance = distance;
	}



	public int getIdx() {
		return idx;
	}



	public void setIdx(int idx) {
		this.idx = idx;
	}



	public int getDistance() {
		return distance;
	}



	public void setDistance(int distance) {
		this.distance = distance;
	}



	// 거리가 짧은 순(오름차순)
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.distance - o.distance;
	}
	
	
}


public class Test01 {
	
	public static int n,m,start; // 노드갯수, 간선의 갯수, 노드 시작 번호
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static int[] d = new int[100001]; // 노드 갯수가 100000인 최단거리 테이블 
											 // 1번 노드부터 100000번 노드까지 만들기위해 100001개 생성
	
	public static final int INF = (int) 1e9;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();
		
		// 그래프 초기화
		for(int i=0;i<n;i++) graph.add(new ArrayList<Node>());
		
		// 모든 간선 정보(a노드에서 b노드로 가는 비용 c)입력
		for(int i=0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			graph.get(a).add(new Node(b,c));
		}
		
		// 최단거리 테이블(d) 무한으로 초기화
		Arrays.fill(d, INF);
		
		dijkstra(start);
		
		for(int i=1;i<=n;i++) {
			if(d[i] == INF) System.out.println("INF");
			else System.out.println(d[i]);
		}
	}

	private static void dijkstra(int start) {
		// TODO Auto-generated method stub
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		// 시작 노드이니까 (시작노드 번호,거리= 0)으로 시작
		pq.offer(new Node(start,0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			
			Node node = pq.poll();
			int distance = node.getDistance();
			int now = node.getIdx();
			
			// 현재 출발점에서부터 now노드 까지의 최단거리 테이블 값(d[now])보다 
			// 이전노드에서 부터 now노드까지의 거리가 더 클 때는 무시
			if(d[now] < distance) continue;
			
			for(int i=0;i<graph.get(now).size();i++) {
				
				int cost = d[now] + graph.get(now).get(i).getDistance();
				// graph가 2차원 리스트이기에 두번 접근
				
				// 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧으면 갱신시키기
				if(d[graph.get(now).get(i).getIdx()] > cost) {
					d[graph.get(now).get(i).getIdx()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIdx(),cost));
				}
				
			}
		}
		
	}

}
