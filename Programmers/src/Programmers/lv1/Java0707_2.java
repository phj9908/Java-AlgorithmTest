// 다트게임
package Programmers.lv1;

public class Java0707_2 {
    public int solution(String dartResult) {
        int answer = 0;
        boolean star = false;
        
        for(int i=dartResult.length()-1;i>=0;i--) {
        	
        	int score =0;
        	
        	if(Character.isAlphabetic(dartResult.charAt(i))){
        		if(i-2>=0 && Character.isDigit(dartResult.charAt(i-2)))
        			// 점수가 두자릿수 이면
        				score=Integer.parseInt(dartResult.substring(i-2, i)); // i-2부터 i-1까지 파싱
        		else score = dartResult.charAt(i-1) - '0';
        		// char형 - '0' : 아스키 연산을 토대로 char -> int변환
        		
        		if(dartResult.charAt(i)=='T') { score= (int)Math.pow(score, 3);}
        		else if (dartResult.charAt(i)=='D') score = (int)Math.pow(score, 2);
        		
        		if(star) {
        			score*=2;
        			star = false;
        		}
        		
        		if(i+1<dartResult.length() && dartResult.charAt(i+1)=='*') {
        			score*=2;
        			star = true;
        		}else if (i+1<dartResult.length() && dartResult.charAt(i+1)=='#')
        			score *=-1;
        	}
        	answer +=score;
        	
        }
        
        return answer;
    }
}
