// 없는 숫자 더하기

package Programmers;

import java.util.Arrays;

class java0703_3 {
	String[] arr= {"0","1","2","3","4","5","6","7","8","9"};  // contain() 를 쓰기위해 각 원소가 String 이어야 함
	
	public int solution(int[] numbers) {
		int answer=0;
		String toString_numbers = Arrays.toString(numbers); // 숫자 배열을 문자열로 변환
		
		for( String num: arr) {
			if(toString_numbers.contains(num)) { // contain(String)
				continue;
			}else {
				answer+=Integer.parseInt(num); // 문자열을 숫자로 
			}
		}
		
		return answer;
	}
}
