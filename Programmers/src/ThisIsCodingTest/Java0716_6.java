// 도시 분할 계획
// 한 길로 연결된 모든 집을 두 개의 마을로 분리하기위해
// 집합에서 가장 비용이 많이 드는 간선 하나 빼기

package ThisIsCodingTest;

import java.util.*;

class Edge implements Comparable<Edge>{
	
	private int cost,nodeA,nodeB;
	
	public Edge(int a,int b,int cost) {
		
		this.cost = cost;
		this.nodeA = a;
		this.nodeB = b;
		
	}

	public int getNodeA() {
		return this.nodeA;
	}

	public int getNodeB() {
		return this.nodeB;
	}

	public int getCost() {
		return this.cost;
	}

	@Override
	public int compareTo(Edge o) {
		
		return this.cost - o.cost; 
		
		// 아래코드로 하면 에러 발생,,
//		if(this.cost < o.cost) return -1; 
//		return 1;
	}
}

public class Java0716_6 {

	public static int n,m;
	public static int[] parent = new int[100001];
	public static ArrayList<Edge> edges = new ArrayList<Edge>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n=sc.nextInt();
		m = sc.nextInt();
		
		for(int i=1;i<=n;i++) parent[i] = i;
		
		for(int i=0;i<m;i++) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			
			edges.add(new Edge(a,b,cost));
		}
		
		Collections.sort(edges);
		
		int answer =0;
		int last = 0; // 집합에 포함되는 간선 중 가장 비용이 큰 간선
		
		for(int i=0;i<edges.size();i++) {
			
			int a = edges.get(i).getNodeA();
			int b = edges.get(i).getNodeB();
			int cost = edges.get(i).getCost();
			
			if (findParent(a) != findParent(b)) { 
			
				unionParent(a,b);
				
				answer+=cost;
				last = cost;
				// 마지막 간선의 비용 저장
			}
		}
		
		System.out.print(answer - last);
	}

	public static void unionParent(int a, int b) {
		
		a = findParent(a);
		b = findParent(b);
		if(a<b) parent[b] =a;
		else parent[a] =b;
		
	}

	public static int findParent(int x) {
		
		if(x == parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}

}
