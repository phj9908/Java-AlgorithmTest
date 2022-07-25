// 커뮤러닝 - 위장

package Programmers.lv2;

import java.util.*;

public class Java0720_1 {
    public int solution(String[][] clothes) {
    	
    	HashMap<String,Integer> map = new HashMap<>();    	
    	
    	for(String[] str:clothes) map.put(str[1], map.getOrDefault(str[1], 0)+1);
    	// getOrDefault() = map.get(str[1])==null ? 0:map.get(str[1])
    	
        int answer = 1;
        for(String key:map.keySet()) 
        	answer*=map.get(key) +1; // 안 입는 경우 +1
        
        return answer -1; // 아무것도 안 입는 경우는 없으므로 빼기
    }
	
}


// Stream 활용
class Solution{
	public int solution(String[][] clothes) {
		int answer = Arrays.stream(clothes) // clothes배열을 객체로서 불러옴
				.map(c -> c[1])				// 옷의 종류, 인덱스 1의 요소 가져오기
				.distinct() 				// 중복없이
				.map(type -> (int) Arrays.stream(clothes).filter(c -> c[1].equals(type)).count()) 
				// 같은 type이면 count
				.map(c -> c+1)				// 같은 type별로 +1
				.reduce(1,(c,n) -> c*n);	// 스트림의 모든 요소를 차례로 돌며, 초기값 1에 계산식 c*n을 누적
		
		return answer-1;
	}
}