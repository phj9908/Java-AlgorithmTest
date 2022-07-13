// 2주차_커뮤러닝 모의테스트 - 구현
// 맞는지 모르겠음
package Programmers.lv2;

import java.util.*;
 

public class Java0713_2 {
    public String[] solution(String[][] booked, String[][] unbooked) {
        String[] answer = {};
        boolean firstBoolean =true;
        String[] recent = new String[2]; // {에약시간,이름}
        
        // booked 와 unbooked중에 가장 빠른 시간 먼저 꺼내기
        Queue<String[]> bq = new LinkedList<>();
        Queue<String[]> unq = new LinkedList<>();
        for(String[] b:booked) bq.offer(b);
        for(String[] ub:unbooked) unq.offer(ub);
        
        int length = booked.length+unbooked.length;
        
        for(int i=0;i<length;i++) {
        
	        String[] bStr = (!bq.isEmpty())? bq.peek():null;
	        String[] ubStr = (!unq.isEmpty())? unq.peek():null;
	        
	        int bTime = Integer.parseInt(bStr[0].replace(":",""));
	        int ubTime = Integer.parseInt(ubStr[0].replace(":",""));
	        
	        if(firstBoolean) {
	        	if(bTime<ubTime) {
	        		recent = bStr;
	        		bq.poll();
	        	}else {
	        		recent = ubStr;
	        		unq.poll();
	        	}
	        	
	        	firstBoolean = false;
	        }
	        else {
	        	// first + 10분 숫자 변환 
	        	int firstP10 = Integer.parseInt(recent[0].replace(":",""))+10;
	
	        	if(ubTime<firstP10 && bTime>firstP10) recent = ubStr;
	        	else recent = bStr;
	        	// ubTime이 그것보다 작고 bTime이 그것보다 크면 ubStr먼저
	        	// 그 외 경우 bStr이 먼저
	        }
        	
   
	        // answer에 이름 담고
	        answer[i] = recent[1];	
        }

        return answer;
    }
}
