// 큰수 만들기
package Programmers.HighScoreKit;

import java.util.*;

// Stack 활용 ver
public class Greedy0806_1 {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k> 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        for (int i=0; i<result.length; i++) 
            result[i] = stack.get(i);
        
        
        return new String(result); // char[]을 String으로 리턴
    }
}

// StringBuilder 활용
class Solution0806 {
    public String solution(String number, int k) {
    	
        StringBuilder sb = new StringBuilder(number);
        
        for (int i = 0; i+1 < sb.length() && k>0; i++) {
            if(sb.charAt(i) < sb.charAt(i+1)) {
                sb.deleteCharAt(i);
                i=-1;
                k--;
            }
        }
        if(k!=0)
            sb.delete(sb.length()-k, sb.length());
        
        return sb.toString();
    }
}

// 수정전
//public class Greedy0806_1 {
//	public String solution(String number,int k) {
//		
//		List<Character> arr = new ArrayList<>();
//		
//		for(int i=0;i<number.length();i++) {
//			while(arr.size()>0&&arr.get(arr.size()-1)<number.charAt(i)&&k>0) {
//				arr.remove(arr.size()-1);
//				k--;
//			}
//			
//			if(k==0) {
//				int idx = i;
//				while(idx<number.length()) { 
//					arr.add(number.charAt(idx));
//					idx++;
//				}
//				
//				break;
//			}
//			arr.add(number.charAt(i));
//		}
//		 
//		// 9876 같이 이미 내림차순 정렬돼있으면
//		// 뒤에서 부터 k개 만큼 빼기
//		if(k>0) {		
//			arr.remove(arr.size()-1);
//			k--;
//		}
//		
//		String answer="";
//		for(char c:arr)
//			answer+=c;
//		
//		return answer;
//	}
//}


