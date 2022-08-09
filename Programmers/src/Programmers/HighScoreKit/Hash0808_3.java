// 전화번호 목록

package Programmers.HighScoreKit;

import java.util.HashMap;

public class Hash0808_3 {
	public boolean solution(String[] phone_book) {
		
		HashMap<String,Integer> map = new HashMap<>();
		for(String s:phone_book)
			map.put(s, 0);
		
		for(String str:phone_book) {
			for(int j=1;j<str.length();j++) {
				String subStr = str.substring(0,j);
				if(map.containsKey(subStr))
					return false;
			}
				
		}
		
		return true;
	}
}
