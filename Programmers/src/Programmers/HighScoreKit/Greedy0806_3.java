// 섬 연결하기
// 크루스칼 알고리즘

package Programmers.HighScoreKit;

import java.util.*;

public class Greedy0806_3 {
	
	public static int[] parent = new int[101];
	
	public int solution(int n,int[][] costs) {
		
		int answer=0;
		
		// 비용기준(세번째 요소) 오름차순 정렬 
		Arrays.sort(costs,(a,b)->Integer.compare(a[2], b[2]));
		
		// 처음에는 자기 자신을 부모로 초기화
		for(int i=0;i<n;i++)
			parent[i] = i;
		
		for(int[] edge:costs) {
			int from = edge[0];
			int to = edge[1];
			int cost = edge[2];
			
			if(findParent(from)!=findParent(to)) {
				unionParent(from,to);
				answer+=cost;
			}
			
		}
		
		return answer;
	}

	private void unionParent(int from, int to) {
		from = findParent(from);
		to = findParent(to);
		if(from<to) parent[to] = from;
		else parent[from] = to;
		
	}

	private static int findParent(int x) {
		if(x==parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}
}
