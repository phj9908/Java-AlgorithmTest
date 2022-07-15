// 전보

package ThisIsCodingTest;

import java.util.*;

class Node implements Comparable<Node> {
	
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
		return this.distance;
	}

	
	@Override
	public int compareTo(Node o) {
		if(this.distance < o.distance) return -1;
		return 0;
	}
	
	
}

public class Java0715_3 {
	
	public static int n,m,start;
	public static int[] d= new int[30001]; // 도시의 개수 만큼 최단거리 테이브 생성
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	
	public static final int INF = (int)1e9;
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();
		
		for(int i=0;i<n;i++) graph.add(new ArrayList<Node>());
		
		Arrays.fill(d, INF);
		
		for(int i=0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			graph.get(a).add(new Node(b,c));
		}
		
		dijstra(start);
		
		// 출발점으로부터 연결된 도시의 수
		int cnt = 0;
		
		// 연결된 도시 중, 가장 멀리있는 도시와의 거리
		int maxDistance =0;
		
		for(int i=1;i<=n;i++) {
			if(d[i]!=INF) {
				cnt++;
				maxDistance = Math.max(maxDistance, d[i]);
			}
		}
		
		System.out.print((cnt-1) +" " + maxDistance); 
		// 시작 노드제외 하기위해 cnt-1
	}

	public static void dijstra(int start) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			
			Node node = pq.poll();
			
			int distance = node.getDistance();
			int nowIdx = node.getIdx();
			
			if(d[nowIdx] < distance) continue;
			
			for(int i=0;i<graph.get(nowIdx).size();i++) {
				
				int cost = d[nowIdx] + graph.get(nowIdx).get(i).getDistance();
				if(cost < graph.get(nowIdx).get(i).getDistance()) {
					d[nowIdx] = cost;
					
				}
				pq.offer(new Node(graph.get(nowIdx).get(i).getIdx(),cost));
			}
		}
		
	}
}
