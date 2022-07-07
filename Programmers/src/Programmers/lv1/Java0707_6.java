// 자연수 뒤집어 배열로 만들기
package Programmers.lv1;

public class Java0707_6 {
    public int[] solution(long n) {
        
        String n_str = ""+n;
        //문자열 s를 ""와 n을 더해줌으로 n을 문자열로 만들 수 있다.
        // Or String n_str = String.valueOf(n);
        
        int[] answer = new int[n_str.length()];
        
        for(int i=0; i<n_str.length();i++)
        	answer[i] = n_str.charAt((n_str.length()-1)-i)-'0';
        	// char - '0' 함으로써 숫자로 변환
        
        return answer;
    }
}
