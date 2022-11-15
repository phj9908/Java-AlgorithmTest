package Practice.Java1115;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 크루스칼 알고리즘
// (최소한의 비용으로 그래프의 모든 노드들을 거칠수있도록하기
// 따라서 각 노드의 최종 루트노드는 단 하나임
class Edge implements Comparable<Edge>{
	
	private int aNode,bNode,cost;

	public Edge(int aNode, int bNode, int cost) {
		super();
		this.aNode = aNode;
		this.bNode = bNode;
		this.cost = cost;
	}

	public int getaNode() {
		return aNode;
	}

	public int getbNode() {
		return bNode;
	}

	public int getCost() {
		return cost;
	}
	
	// 비용 오름차순 정렬
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.cost - o.cost;
	}
}


public class Test01 {
	
	public static int v,e; // 노드 수, 간선 수
	public static int[] parent = new int[100001];
	
	public static ArrayList<Edge> edges = new ArrayList<Edge>();
	public static int answer=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
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
			
			// 사이클이 발생하지 않는 경우에만 집합에 포함시킴
			if(findParent(a) != findParent(b)) {
				unionParent(a,b);
				answer +=cost;
			}
		}
		
		System.out.println(answer);
	}

	private static void unionParent(int a, int b) {
		// TODO Auto-generated method stub
		a = findParent(a);
		b = findParent(b);
		if(a>b) parent[a] =b;
		else parent[b] = a;
	}

	private static int findParent(int x) {
		// TODO Auto-generated method stub
		if(x == parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}

}
