// 완주하지 못한 선수
// HashMap

package Programmers.lv1;

import java.util.HashMap;

public class Java0704_1 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String,Integer> map = new HashMap<>();
        
        // 초기화
        for(String c: participant) 
        	map.put(c,map.getOrDefault(c, 0)+1); // map.get(c) 에 값이 있다면 기존값, 값이 없었다면 디폴트로 0 
        
        for(String c: completion) 
        	map.put(c, map.get(c)-1);
                
        for(String key:map.keySet()) {
        	if(map.get(key)>0) 
        		answer=key;
        }
        
        return answer;
    }
}
