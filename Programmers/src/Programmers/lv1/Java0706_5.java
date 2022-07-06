// 3진법 뒤집기
package Programmers.lv1;

public class Java0706_5 {
    public int solution(int n) {
        
        String ans="";
        
        while(n>0) {
        	
        	ans += n%3;	// 자동 문자열 변환
        	//ans+=Integer.toString(n%3); // 숫자를 문자열로
        	
        	n/=3; 	// 몫 연산		
        }
        
        return Integer.parseInt(ans,3); // 문자열 형태의 3진수를 십진수로 변환 
    }
}
