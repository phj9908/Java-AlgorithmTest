// 2주차_커뮤러닝 모의테스트 - 구현
// SimpleDataFormat으로 했지만 앞으로는 LocalTime 클래스 권장 
package Programmers.lv2;

import java.text.SimpleDateFormat;
import java.util.*;
import java.text.ParseException;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(String[][] booked, String[][] unbooked) throws ParseException {
        String[] answer = {};
        
        // ArrayList로 옮기기
        List<List<String>> bookedList = Arrays.stream(booked).map(Arrays::asList).collect(Collectors.toList());
        List<List<String>> unbookedList = Arrays.stream(unbooked).map(Arrays::asList).collect(Collectors.toList());

        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm"); 
        // String 으로부터 시간 추출

        List<String> tempAnswer = new ArrayList<>();
        Date endTime = null;
        int length = Math.max(bookedList.size(), unbookedList.size());

        int i = 0;
        int j = 0;
        Date bookedTime = null;
        Date unbookedTime = null;

        while (i < bookedList.size() || j < unbookedList.size()) {
        	
            if (i <bookedList.size()) {
                bookedTime = formatter.parse(bookedList.get(i).get(0));
                // throws ParseException 
            }
            if (j < unbookedList.size()) {
                unbookedTime = formatter.parse(unbookedList.get(j).get(0));
                // throws ParseException
            }

            if (i == 0 && j == 0) { 	// 첫 예약자라면
                endTime = bookedTime.compareTo(unbookedTime) >= 0 ? unbookedTime : bookedTime;
                // bookTime이 unbookedTime보다 크다면
                
                tempAnswer.add(endTime.toString());
            }
            
            else {
            	
            	Calendar unbookedCal = Calendar.getInstance();
            	unbookedCal.setTime(unbookedTime);
            	
            	Calendar bookedCal = Calendar.getInstance();
            	unbookedCal.setTime(bookedTime);
            	
            	Calendar endtimeCal = Calendar.getInstance();
            	endtimeCal.setTime(endTime);
            	
            	endtimeCal.add(Calendar.MINUTE, Calendar.MINUTE + 10);
            	
	        	// endtime+10이 ubtime보다 크고 endtime이 btime보다 작으면 비예약자 먼저
	        	// 그 외 경우 예약자 먼저
	            if (endtimeCal.compareTo(unbookedCal) > 0 && endtimeCal.compareTo(bookedCal) < 0) {
	                tempAnswer.add(bookedList.get(i).get(1));
	                i++;
	            } else {
	                tempAnswer.add(unbookedList.get(j).get(1));
	                j++;
	            }
            }
            

        }

        answer = tempAnswer.toArray(String[]::new); 
        // == return tempAnswer.toArray(new String[tempAnswer.size()]);
        // 리스트를 String[]형태로 변환

        return answer;
    }
}
