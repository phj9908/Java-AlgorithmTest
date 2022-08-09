// 위장

package Programmers.HighScoreKit;

import java.util.HashMap;

public class Hash0808_4 {
	public int solution(String[][] clothes) {
		
		HashMap<String,Integer> map = new HashMap<>();
		
		for(String[] clothe:clothes)
			map.put(clothe[1], map.getOrDefault(clothe[1], 0)+1);
		
		int answer=1;
		for(String key:map.keySet())
			answer*=map.get(key)+1;
		
		return answer-1;
	}
}