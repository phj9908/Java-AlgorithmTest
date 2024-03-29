package Practice.Java1115;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 위상정렬
// 사이클이 없는 방향 그래프의 노드를 방향에 거스르지 않게 순서대로 나열
public class Test02 {
	
	public static int v,e;
	public static int[] indegree = new int[100001];
	
	// 각 노드에 연결된 간선 정보를 담기 위한 그래프
	// 한 노드에 여러개의 선수 노드가 연결될 수 있으니 2차원으로 생성
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		v = sc.nextInt();
		e = sc.nextInt();
		
		for(int i=0;i<=v;i++) graph.add(new ArrayList<Integer>());
		
		for(int i=0;i<e;i++) {
			
			int a = sc.nextInt(); // 선수 노드
			int b = sc.nextInt();
			graph.get(a).add(b); // a->b 간선
			
			indegree[b]++; 		 // 진입차수 1 증가
		}
		
		topologySort(); // 위상정렬
	}

	private static void topologySort() {
		// TODO Auto-generated method stub
		
		// 위상정렬 결과담을 리스트
		ArrayList<Integer> answer = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1;i<=v;i++) {
			
			// 진입차수가 0이면 큐에 넣기(처음엔 진입차수가 0인 노드는 하나뿐)
			if(indegree[i]==0) q.offer(i);
		}
		
		while(!q.isEmpty()) {
			
			// 그림보면서 이해하면 더 쉬움~
			
			int now = q.poll();
			answer.add(now);
			
			// 해당노드와 연결된 노드들의 진입차수에서 1빼기
			for(int i=0;i<graph.get(now).size();i++) {
				indegree[graph.get(now).get(i)]--;
				
				if(indegree[graph.get(now).get(i)] == 0)
					q.offer(graph.get(now).get(i));
			}
		}
		
		//위상정렬을 수행한 결과 출력
		for(int i=0;i<answer.size();i++)
			System.out.println(answer.get(i) + " ");
	}

}
