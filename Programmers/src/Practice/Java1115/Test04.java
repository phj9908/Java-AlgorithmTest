package Practice.Java1115;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 크루스칼 알고리즘 예제
// 한 길로 연결된  모든 집을 두 개의 마을로 분리하기위해
// 집합에서 가장 비용이 많이드는 간선하나 빼기

class Edge implements Comparable<Edge>{
	
	private int cost,nodeA,nodeB;
	
	public Edge(int a,int b,int cost) {
		
		this.cost = cost;
		this.nodeA = a;
		this.nodeB = b;
	}

	public int getCost() {
		return cost;
	}

	public int getNodeA() {
		return nodeA;
	}

	public int getNodeB() {
		return nodeB;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.cost - o.cost;
	}
	
	
}

public class Test04 {
	
	public static int n,m;
	public static int[] parent = new int[100001];
	public static ArrayList<Edge> edges = new ArrayList<Edge>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		n = sc.nextInt();
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
		int last=0; // 집합에 포함되는 간선 중 가장 비용이 큰 간선
		
		for(int i=0;i<edges.size();i++) {
			
			int a = edges.get(i).getNodeA();
			int b = edges.get(i).getNodeB();
			int cost = edges.get(i).getCost();
			
			if(findParent(a) != findParent(b)) {
				unionParent(a,b);
				
				answer+=cost;
				last = cost;
			}
		}
	}

	private static void unionParent(int a, int b) {
		// TODO Auto-generated method stub
		a = findParent(a);
		b = findParent(b);
		if(a>b) parent[a] = b;
		else parent[b] =a;
	}

	private static int findParent(int x) {
		// TODO Auto-generated method stub
		if( x == parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}

}
