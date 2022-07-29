// 선후수 수강 - 커뮤러닝 기말고사(BFS,위상정렬)
// 큐에 아무것도 안담김, 추후 수정 필요

package Programmers.lv3;

import java.util.*;

public class Java0729_1 {
	
	public static HashMap<String,ArrayList<String>> graph =  new HashMap<>();
	public static HashMap<String,Integer> indegree = new HashMap<String,Integer>();
	
    public String[] solution(String[] s1, String[] s2, String k) {
    	
    	HashSet<String> set = new HashSet<String>(Arrays.asList(s1));
    	
    	for(String s:set) {
    		graph.put(s,new ArrayList<String>());
    		indegree.put(s, 0);
    	}
    	for(int i=0;i<s1.length;i++) {
    		
    		graph.get(s1[i]).add(s2[i]); 	// s1[i] -> s2[i]
    		indegree.put(s2[i], indegree.getOrDefault(s2[i], 0)+1);
    		// s2[i]의 진입차수 +1
    	}
    	
    	return topologySort(s1,s2,k); 		// 위상정렬

    }

	private String[] topologySort(String[] s1, String[] s2,String k) {
		
		ArrayList<String> answer = new ArrayList<String>();
		Queue<String> q = new LinkedList<String>();
		
		for(int i=0;i<s1.length;i++) {
			if(indegree.get(s2[i])== 0)
				q.offer(s2[i]);
		}
		
		LOOP1:
		while(!q.isEmpty()) {
			
			String now = q.poll();
			answer.add(now);
			
			LOOP2:
			for(int i=0;i<graph.get(now).size();i++) {
				indegree.put(graph.get(now).get(i),indegree.get(graph.get(now).get(i))-1);
				
				if(indegree.get(graph.get(now).get(i))==0)
					if(graph.get(now).get(i)==k) break LOOP1; 
					else q.offer(graph.get(now).get(i));
			}
		}
		
		return answer.toArray(new String[answer.size()]);
		
	}
}
