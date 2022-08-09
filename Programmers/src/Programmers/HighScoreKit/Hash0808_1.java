// 폰켓몬

package Programmers.HighScoreKit;

import java.util.HashSet;

public class Hash0808_1 {
	public int solution(int[] nums) {
		
		int answer = nums.length/2;
		
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i:nums) set.add(i);
		
		if(set.size()>answer) 
			return answer;
			
		return set.size();
	}
}
