// 우선 순위 큐를 이용한 다익스트라 최단경로 알고리즘
package ThisIsCodingTest;

import java.util.*;

// 각 노드의 번호, 비용에 쉽게 접근하기위해 class 생성
class Node implements Comparable<Node>{
	
	private int idx;
	private int distance;
	
	public Node(int idx, int distance) {
		this.idx = idx;
		this.distance = distance;
	}

	public int getIdx() {
		return this.idx;
	}

	public int getDistance() {
		return distance;
	}

	// 거리가 짧은 순으로 정렬(오름차순)
	@Override
	public int compareTo(Node o) {
		if(this.getDistance() < o.getDistance()) return -1;
		return 1;
	}	
	
}

public class Java0715_1 {
	
	public static int n,m,start;
	// n: 노드 갯수, m : 간선의 갯수, start : 노드 시작 번호
	
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static int[] d = new int[100001]; // 최단거리 테이블 생성(노드 갯수가 100,000라고 가정)
											 // 1번 노드부터 100000번 노드까지 만들기위해 100001개 생성
	public static final int INF = (int) 1e9;
	// 무한을 의미하는 값, 10억 설정
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();
		
		// 그래프 초기화
		for(int i=0;i<n;i++) graph.add(new ArrayList<Node>());
				
		// 모든 간선 정보(a노드에서 b노드로 가는 비용 c) 입력
		for(int i=0; i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			graph.get(a).add(new Node(b,c));
				
		}
		
		// 최단거리 테이블 무한으로 초기화
		Arrays.fill(d, INF); 
		
		dijkstra(start);
		
		// 1번 ~ n번 노드로 가기위한 최단 거리 출력
		for(int i=1; i<=n; i++) {
			
			if(d[i] == INF) System.out.println("INFINITY");
			else System.out.println(d[i]);
		}
	}
	
	public static void dijkstra(int start) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		// Node클래스 내 거리가 짧은 순으로 정렬이 되도록 compareTo() 오버라이딩을 함으로써
		// 우선순위 큐에 각 노드의 정보를 할당함에 따라 
		// 나중에 큐.poll()을 할때 가장 거리가 짧은 노드가 우선순위로 나오게 됨!
		
		// 시작 노드이니까  (시작노드 번호, 거리=0)으로 시작
		pq.offer(new Node(start,0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			
			Node node = pq.poll(); 
			int distance = node.getDistance(); // 현재노드까지의 비용
			int now = node.getIdx(); 		   // 현재 노드 번호
			
			// 현재노드가 이미 처리된 ㄴ적이 있다면 무시
			if(d[now] < distance) continue;
			
			for(int i=0; i<graph.get(now).size();i++) {
				
				int cost = d[now] + graph.get(now).get(i).getDistance();
				// graph가 2차원 리스트이기에 테이블 원소에 접근하려면 get() 2번 사용해야함
				// graph.get(now) 현재 노드
				// graph.get(now).get(i) 현재 노드에 연결된 노드중 하나
				
				// 현재 노드를 거쳐서 다른 노드로 이동하는 거리사 더 짧으면 갱신해주기!
				if(d[graph.get(now).get(i).getIdx()] > cost) {
					d[graph.get(now).get(i).getIdx()] = cost; 
					pq.offer(new Node(graph.get(now).get(i).getIdx(),cost));
				}
			}
			
		}
		
	}
}
