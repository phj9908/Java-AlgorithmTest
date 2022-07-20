// 커뮤러닝

package Programmers.lv2;

import java.util.*;

public class Java0720_1 {
    public int solution(String[][] clothes) {
    	
    	HashMap<String,Integer> map = new HashMap<>();    	
    	
    	for(String[] str:clothes) map.put(str[1], map.getOrDefault(str[1], 0)+1);
    	
        int answer = 1;
        for(String key:map.keySet()) 
        	answer*=map.get(key) +1; // 안 입는 경우 +1
        
        return answer -1; // 아무것도 안 입는 경우는 없으므로 빼기
    }
	
}
