// 위상정렬

package ThisIsCodingTest;

import java.util.*;

public class Java0717_1 {
	
	public static int n;
	public static int[] indegree = new int[501]; // new int[n+1]로 하면 인덱스 에러 발생
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static int[] times = new int[501]; 	// 각 강의번호의 고유 강의 시간
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		for(int i=0; i<=n;i++)
			graph.add(new ArrayList<Integer>());
		
		// 입력 10 1 2 -1 이면 10:강의 시간/ 1,2: 이 과목의 선수 과목
		for(int i=1;i<=n;i++) {   // i = 강의 번호
			int a = sc.nextInt(); // 강의 시간
			times[i] = a;
			
			while(true){
				
				int x = sc.nextInt(); // 선수 과목 or -1
				if(x!=-1) {
					graph.get(x).add(i);
					// 주의) x -> i 방향! 
					
					indegree[i]++;
					
				}else break;
				
			}
			
		}
		
		topologySort();

	}

	public static void topologySort() {
		
		Queue<Integer> q = new LinkedList<>();
		int[] answer = new int[501];		  // 각 강의당 선수과목을 거쳐 합한 시간
		for(int i=1;i<=n;i++) answer[i] = times[i];
		
		// 처음 시작할 땐 진입차수가 0인 노드 삽입
		for(int i=1; i<=n; i++) {
			if( indegree[i] == 0) q.offer(i);
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
