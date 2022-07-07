// 문자열 내 맘대로 정렬하기
package Programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;

public class Java0707_3 {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        ArrayList<String> arr = new ArrayList<String>();
        
        for(int i=0;i<strings.length;i++) 
        	arr.add(strings[i].charAt(n)+strings[i]); 
        	// n번쨰 문자를 기준으로 정렬해야 하기에 맨 앞에 더해주기
        
        answer = arr.toArray(new String[arr.size()]);
        // ArrayList -> 배열
        Arrays.sort(answer);
        
        for(int i=0; i< answer.length;i++)
        	answer[i] = answer[i].substring(1); 
        	// 아까 더했던 문자 제외하고 할당
        
        return answer;
    }
}
