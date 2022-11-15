package Practice.Java1115;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 위상정렬 예제 - 커리큘럼
public class Test05 {

	public static int n;
	public static int[] indegree = new int[501];
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static int[] times = new int[501]; // 각 강의번호의 고유 강의 시간
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=0;i<=n;i++) graph.add(new ArrayList<Integer>());
		
		for(int i=1;i<=n;i++) {
			
			int a = sc.nextInt(); // 강의 시간
			times[i] = a;
			
			while(true) {
				
				int x = sc.nextInt(); // 선수과목 or -1
				if(x!=-1) {
					
					graph.get(x).add(i);
					// x -> i
					
					indegree[i]++;
					
				}else break;
			}
		}
		topologySort();
		
		
	}

	private static void topologySort() {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		int[] answer = new int[501]; // 각 강의당 선수과목을 거쳐 합한 시간
		for(int i=1;i<=n;i++) answer[i] = times[i];
		
		// 처음 시작할 때 진입차수가 0인 노드 삽입
		for(int i =1;i<=n;i++) {
			if(indegree[i] ==0) q.offer(i);
		}
		
		while(!q.isEmpty()) {
			
			int nowIdx = q.poll();
			
			for(int i=0;i<graph.get(nowIdx).size();i++) {
				
				indegree[graph.get(nowIdx).get(i)]--;
				
				int result = answer[graph.get(nowIdx).get(i)];
				result = Math.max(result, answer[nowIdx] + times[graph.get(nowIdx).get(i)]);
				
				answer[graph.get(nowIdx).get(i)] = result;
				
				if(indegree[graph.get(nowIdx).get(i)] == 0)
					q.offer(graph.get(nowIdx).get(i));
			}
		}
		
		for(int i=1;i<=n;i++) System.out.println(answer[i]);
	}

}
