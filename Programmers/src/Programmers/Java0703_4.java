// 음양더하기

package Programmers;

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i=0;i<absolutes.length;i++) {
        	if(signs[i]) {
        		answer+=absolutes[i];
        	}else {
        		answer-=absolutes[i];
        	}
        }
//        // Or 삼항연산자 이용
//        for (int i = 0; i < absolutes.length; i++) {
//            answer += (signs[i]) ? absolutes[i] : -absolutes[i];
//        }
        
        return answer;
    }
}
