// DFS로 그래프(2차원 연결리스트로 구현) 탐색

package ThisIsCodingTest;

import java.util.ArrayList;

public class Java0712_1 {
	
	public static boolean[] visited = new boolean[9];
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	// DFS함수 정의
	public static void dfs(int x) {
		
		visited[x] = true;		// 현재 노드 방문 처리
		System.out.print(x+" ");
		
		// 현재 노드에 연결된 노드들 방문
		for(int i=0; i<graph.get(x).size();i++) {
			
			int y = graph.get(x).get(i);
			if(!visited[y]) dfs(y);
		}
		// return 필요없이, for문이 완전히 처리됨에 따라 진행!!
	}
	
	public static void main(String[] args) {
		
		// 그래흐 초기화(노드 1부터 8까지 이뤄진 그래프)
		for(int i=0; i<9; i++) graph.add(new ArrayList<Integer>());
		
		// 노드 1에 연결된 노드 정보 저장
		graph.get(1).add(2);
		graph.get(1).add(3);
		graph.get(1).add(8);
		
        // 노드 2에 연결된 노드 정보 저장 
        graph.get(2).add(1);
        graph.get(2).add(7);
        
        // 노드 3에 연결된 노드 정보 저장 
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);
        
        // 노드 4에 연결된 노드 정보 저장 
        graph.get(4).add(3);
        graph.get(4).add(5);
        
        // 노드 5에 연결된 노드 정보 저장 
        graph.get(5).add(3);
        graph.get(5).add(4);
        
        // 노드 6에 연결된 노드 정보 저장 
        graph.get(6).add(7);
        
        // 노드 7에 연결된 노드 정보 저장 
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);
        
        // 노드 8에 연결된 노드 정보 저장 
        graph.get(8).add(1);
        graph.get(8).add(7);

        dfs(1);
	}
}
