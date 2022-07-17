// 크루스칼 알고리즘 

package ThisIsCodingTest;

import java.util.*;

// 두 노드 a,b와 그 사이 거리를 동시에 저장,접근하기 위해 클래스 생성
class Edge implements Comparable<Edge>{
	
	public Edge(int a, int b, int cost) {
		this.aNode = a;
		this.bNode = b;
		this.cost = cost;
	}

	public int getaNode() {
		return this.aNode;
	}

	public int getbNode() {
		return this.bNode;
	}

	public int getCost() {
		return this.cost;
	}

	private int aNode,bNode,cost;

	// 비용 오름차순 정렬
	@Override 
	public int compareTo(Edge o) {
		if(this.getCost() < o.getCost()) return -1;
		return 1;
	}
	
}

public class Java0716_3 {
	public static int v,e;
	public static int[] parent = new int[100001];
	
	public static ArrayList<Edge> edges = new ArrayList<Edge>();
	public static int answer =0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		v = sc.nextInt();
		e = sc.nextInt();
		
		for(int i=1;i<=v;i++) parent[i] = i;
		
		for(int i=0;i<e;i++) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			
			edges.add(new Edge(a,b,cost));
		}
		
		// 간선을 비용 기준으로 정렬
		Collections.sort(edges);
		
		for(int i=0;i<edges.size();i++) {
			
			int cost = edges.get(i).getCost();
			int a = edges.get(i).getaNode();
			int b = edges.get(i).getbNode();
			
			// 사이클이 발생하지 않는 경우에만 집합에 포합시킴
			if(findParent(a) != findParent(b)){
				unionParent(a,b);
				answer += cost;
			}
		}
			
		System.out.print(answer);
		
	}

	public static void unionParent(int a, int b) {
		
		a = findParent(a);
		b = findParent(b);
		if(a<b) parent[b] =a;
		else parent[a] = b;
		
	}

	private static int findParent(int x) {
		
		if(x == parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}
}
