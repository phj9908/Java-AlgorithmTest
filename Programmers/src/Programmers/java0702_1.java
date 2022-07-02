// 신고 결과 받기

package Programmers;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String,Integer> id_index = new HashMap<>(); 
        HashMap<String,HashSet<String>> report_map = new HashMap<>(); // key:신고받은 사람 - value:신고한 사람리스트
        // HashSet<> : 동일한 유저에 대한 신고는 중복이 불가함. (예시2번 참고)
        
        // 초기화
        int i=0;
        for(String id:id_list) {
        	id_index.put(id, i++); // 마지막에 answer에 id_list의 원소 index에 맞게 값을 할당하기 위함
        	report_map.put(id, new HashSet<String>());
        }
        
        // 신고된 사람들이 누구에게 지목을 받았는지
        for(String r : report) {
        	String[] id = r.split(" ");
        	report_map.get(id[1]).add(id[0]); // key = id[1](신고받은 사람)의 value[]에 id[0](신고한 사람)추가
        }
        
        // answer에 id_list의 원소 순서에 맞게 신고확정된 사람등 수 할당
        for(String id:id_list) {
        	HashSet<String> str = report_map.get(id); // id를 지목한 사람들 리스트 얻기
        	if (str.size()>=k) {  	// 지목한 사람들의 수가 k명 이상일 때
        		for( String name:str) {
        			answer[id_index.get(name)]++; // name에 해당하는 사람의 인덱스에 값 할당
        		}
        	}
        }
        return answer;
    }
}
