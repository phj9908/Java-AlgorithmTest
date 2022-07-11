// 가장 큰 수 - 커뮤러닝 코테
package Programmers.lv2;

import java.util.Arrays;

public class Java0708_2 {
    public String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];
        
        for(int i=0;i<numbers.length;i++) {
        	str[i] = String.valueOf(numbers[i]);
        	// or str[i] = numbers[i] + "";
        }
        
        Arrays.sort(str,(a,b)-> (b+a).compareTo(a+b));
        // 내림차순 정렬
        // 예) 30 과 3 을 정렬 할 때, 3 30 순서가 돼야 함
       	// 두 수 a,b를 순서를 번갈아가며 합친 수(330,303) 중 큰 값을 앞으로 정렬하겠다     
        
        for(String s:str) answer+=s;
        // answer = String.join("",str);
        
        return answer.charAt(0) == '0' ? "0":answer;
        // answer.startsWith("0")? "0":answer;
        // {0,0,0,0...} 일 경우 0 출력
    }
}

// Stream 활용

//import java.util.*;
//import java.util.stream.*;
//
//public class Java0708_2 {
//    public String solution(int[] numbers) {
//        String answer = "";
//        
//        answer = IntStream.of(numbers)			// Integer의 배열 생성
//        		.mapToObj(String::valueOf)		// 배열을 String으로 변경
//        		.sorted((s1,s2) -> (s2+s1).compareTo(s1+s2))	// 내림파순으로 정렬
//        		.collect(Collectors.joining());					// 배열의 원소를 하나의 문자열로 합치기
//        
//        return answer.startsWith("0")? "0":answer;
//        // {0,0,0,0...} 일 경우 0 출력
//    }
//}