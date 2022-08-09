// 완주하지 못한 선수
package Programmers.HighScoreKit;

import java.util.HashMap;

public class Hash0808_2 {
	public String solution(String[] participant,String[] completion) {
		String answer ="";
		
		HashMap<String,Integer> map = new HashMap<>();
		
		// 초기화
		for(String c:participant)
			map.put(c, map.getOrDefault(c, 0)+1);
		
		for(String c:completion)
			map.put(c, map.get(c)-1);
		
		for(String key:map.keySet()) {
			if(map.get(key)>0)
				answer=key;
		}
		
		return answer;
	}
}
