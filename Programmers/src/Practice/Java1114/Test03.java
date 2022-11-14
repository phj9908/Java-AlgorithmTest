package Practice.Java1114;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// 다익스트라 예제
class Node implements Comparable<Node>{
	private int idx,distance;
	
	public Node(int idx, int distance) {
		super();
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



	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.distance - o.distance;
	}
	
	
}


public class Test03 {
	
	public static int n,m,start;
	public static int[] d = new int[30001]; // 도시ArrayList<E> 생성
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();)
	
	public static final int INF = (int)1e9;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
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
		
		
		
	}

	private static void dijstra(int start) {
		// TODO Auto-generated method stub
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
				if(cost < d[graph.get(nowIdx).get(i).getIdx()])
				{
					d[graph.get(nowIdx).get(i).getIdx()] = cost;
					pq.offer(new Node(graph.get(nowIdx).get(i).getIdx(),cost));
				}
				
				
			}
		}
		
	}
	

}
